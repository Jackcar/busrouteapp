package com.quicksilverbus.busroute.di.module

import com.quicksilverbus.busroute.features.routeDetails.RouteDetailsPresenter
import com.quicksilverbus.busroute.features.routeList.RouteListPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun providesRouteListPresenter(): RouteListPresenter = RouteListPresenter()

    @Provides
    fun providesRouteDetailsPresenter(): RouteDetailsPresenter = RouteDetailsPresenter()
}