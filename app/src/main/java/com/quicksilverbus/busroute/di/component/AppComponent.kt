package com.quicksilverbus.busroute.di.component;

import com.quicksilverbus.busroute.di.module.AppModule;
import com.quicksilverbus.busroute.di.module.DataModule
import javax.inject.Singleton
import dagger.Component

@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {
//    fun inject()
}
