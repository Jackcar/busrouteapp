package com.quicksilverbus.busroute.data.remote

import com.quicksilverbus.busroute.App
import com.quicksilverbus.busroute.data.RoutesDataSource
import com.quicksilverbus.busroute.model.Route
import io.reactivex.Observable
import javax.inject.Inject

class RoutesRemoteDataSource : RoutesDataSource {

    @Inject
    lateinit var mApi: RestApi

    init {
        App.appComponent().inject(this)
    }

    override fun routes(): Observable<List<Route>> {
        return mApi.routes()
    }

}