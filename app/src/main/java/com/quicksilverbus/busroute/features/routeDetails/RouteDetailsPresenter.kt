package com.quicksilverbus.busroute.features.routeDetails

import com.quicksilverbus.busroute.App
import com.quicksilverbus.busroute.base.BaseMvpPresenterImpl
import com.quicksilverbus.busroute.data.RoutesRepository
import com.quicksilverbus.busroute.model.Route
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RouteDetailsPresenter : BaseMvpPresenterImpl<RouteDetailsContract.View>(), RouteDetailsContract.Presenter {

    @Inject
    lateinit var mRoutesRepository: RoutesRepository

    init {
        App.appComponent().inject(this)
    }

    override fun showRouteDetails(route: Route) {
        mView?.showTitle(route.name)
        mView?.showImage(route.image)
        mView?.showAccessible(route.accessible)
        mView?.showDescription(route.description)
    }

}