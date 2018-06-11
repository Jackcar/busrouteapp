package com.quicksilverbus.busroute.data

import com.quicksilverbus.busroute.model.Route
import io.reactivex.Observable

interface RoutesDataSource {
    fun routes(): Observable<List<Route>>
}