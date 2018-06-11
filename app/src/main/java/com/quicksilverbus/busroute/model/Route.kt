package com.quicksilverbus.busroute.model

import java.io.Serializable

data class Route(val id: String,
                 val name: String,
                 val stops: List<Route>,
                 val description: String,
                 val accessible: Boolean,
                 val image: String) : Serializable