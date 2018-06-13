package com.quicksilverbus.busroute.features.routeList

import com.quicksilverbus.busroute.App
import com.quicksilverbus.busroute.base.BaseMvpPresenterImpl
import com.quicksilverbus.busroute.data.RoutesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RouteListPresenter : BaseMvpPresenterImpl<RouteListContract.View>(), RouteListContract.Presenter {

    @Inject
    lateinit var mRoutesRepository: RoutesRepository

    init {
        App.appComponent().inject(this)
    }

    override fun getRoutes() {
        add(mRoutesRepository.routes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { mView?.showLoading() }
                .doOnTerminate { mView?.dismissLoading() }
                .subscribe(
                        { routes ->
                            mView?.displayRoutes(routes)
                        },
                        { e ->
                            mView?.emptyList()
                        }
                )
        )
    }

}