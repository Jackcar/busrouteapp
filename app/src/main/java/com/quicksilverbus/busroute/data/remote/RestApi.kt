package com.quicksilverbus.busroute.data.remote

import com.quicksilverbus.busroute.data.remote.model.RouteResponse
import com.quicksilverbus.busroute.model.Route
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {

    @GET("5808f00d10000005074c6340")
    fun routes() : Observable<RouteResponse>

}