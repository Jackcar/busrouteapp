package com.quicksilverbus.busroute.di.component;

import com.quicksilverbus.busroute.data.remote.RoutesRemoteDataSource
import com.quicksilverbus.busroute.di.module.AppModule;
import com.quicksilverbus.busroute.di.module.DataModule
import com.quicksilverbus.busroute.features.routeList.RouteListPresenter
import javax.inject.Singleton
import dagger.Component

@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {
    fun inject(routesRemoteDataSource: RoutesRemoteDataSource)
    fun inject(routeListPresenter: RouteListPresenter)
}
