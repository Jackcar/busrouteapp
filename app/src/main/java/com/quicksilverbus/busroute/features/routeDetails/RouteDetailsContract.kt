package com.quicksilverbus.busroute.features.routeDetails

import com.quicksilverbus.busroute.base.BaseMvpPresenter
import com.quicksilverbus.busroute.base.BaseMvpView
import com.quicksilverbus.busroute.model.Route


object RouteDetailsContract {

    interface View : BaseMvpView {
        fun showTitle(title: String)
        fun showImage(imageUrl: String)
        fun showAccessible(accessible: Boolean)
        fun showDescription(description: String)
        fun showStops(stops: List<Route>)
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun showRouteDetails(route: Route)
    }

}