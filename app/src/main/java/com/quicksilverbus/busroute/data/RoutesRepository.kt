package com.quicksilverbus.busroute.data

import com.quicksilverbus.busroute.data.remote.RoutesRemoteDataSource
import com.quicksilverbus.busroute.model.Route
import io.reactivex.Observable
import javax.inject.Inject

class RoutesRepository @Inject constructor(val mRoutesRemoteDataStore: RoutesRemoteDataSource) : RoutesDataSource {

    override fun routes(): Observable<List<Route>> {
        return mRoutesRemoteDataStore.routes()
    }

}