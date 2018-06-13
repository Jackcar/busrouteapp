package com.quicksilverbus.busroute.di.module

import android.app.Application
import com.quicksilverbus.busroute.BuildConfig
import com.quicksilverbus.busroute.data.remote.RestApi
import com.quicksilverbus.busroute.data.remote.RoutesRemoteDataSource
import com.quicksilverbus.busroute.features.routeList.RouteListPresenter
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun providesRouteListPresenter() = RouteListPresenter()

}