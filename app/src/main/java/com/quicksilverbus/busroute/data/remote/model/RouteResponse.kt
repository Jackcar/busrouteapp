package com.quicksilverbus.busroute.data.remote.model

import com.google.gson.annotations.SerializedName
import com.quicksilverbus.busroute.model.Route


class RouteResponse(
        @SerializedName("routes")
        val routes: List<Route>
)