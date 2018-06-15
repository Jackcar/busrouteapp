package com.quicksilverbus.busroute.features.routeList

import com.quicksilverbus.busroute.base.BaseMvpPresenter
import com.quicksilverbus.busroute.base.BaseMvpView
import com.quicksilverbus.busroute.model.Route


object RouteListContract {

    interface View : BaseMvpView {
        fun showLoading()
        fun dismissLoading()
        fun displayRoutes(routes: List<Route>)
        fun emptyList()
        fun showNoConnection()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun getRoutes()
    }

}