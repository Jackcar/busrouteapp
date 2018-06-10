package com.quicksilverbus.busroute

import android.app.Application
import com.quicksilverbus.busroute.di.component.AppComponent
import com.quicksilverbus.busroute.di.component.DaggerAppComponent
import com.quicksilverbus.busroute.di.module.AppModule
import com.quicksilverbus.busroute.di.module.DataModule

class App : Application() {

    companion object {
        lateinit var mAppComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        setupDagger()
    }

    // --------------------------------------------------------------------------------------------
    // SETUP
    // --------------------------------------------------------------------------------------------

    private fun setupDagger() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .dataModule(DataModule())
                .build()
    }

}