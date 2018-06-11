package com.quicksilverbus.busroute.features.routeDetails

import com.quicksilverbus.busroute.base.BaseMvpPresenter
import com.quicksilverbus.busroute.base.BaseMvpView
import com.quicksilverbus.busroute.model.Route


object RouteDetailsContract {

    interface View : BaseMvpView {
        fun showDetails()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun getRoutes()
    }

}