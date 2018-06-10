package com.quicksilverbus.busroute.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var mApp: Application) {

    @Provides
    @Singleton
    fun providesApplication() = mApp

}