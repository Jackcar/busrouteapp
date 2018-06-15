package com.quicksilverbus.busroute.di.module

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.quicksilverbus.busroute.App
import com.quicksilverbus.busroute.BuildConfig
import com.quicksilverbus.busroute.data.remote.RestApi
import com.quicksilverbus.busroute.data.remote.RoutesRemoteDataSource
import com.quicksilverbus.busroute.exception.NoNetworkException
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Singleton
import javax.net.ssl.SSLPeerUnverifiedException

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesHttpCache(application: Application): Cache {
        val cacheSize: Long = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(app: Application, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor()
                        .apply { level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE })
                .addInterceptor { chain ->
                    val requestBuilder = chain.request().newBuilder()

                    try {
                        chain.proceed(requestBuilder.build())
                    } catch (e: SocketTimeoutException) {
                        throw NoNetworkException
                    } catch (e: UnknownHostException) {
                        throw NoNetworkException
                    }
                }
                .cache(cache)
                .build()
    }

    @Provides
    @Singleton
    fun providesApi(okHttpClient: OkHttpClient): RestApi {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        return retrofit.create(RestApi::class.java)
    }


    @Provides
    @Singleton
    fun providesRoutesRepository() = RoutesRemoteDataSource()

}