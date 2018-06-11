package com.quicksilverbus.busroute.features.routeDetails

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.quicksilverbus.busroute.R
import com.quicksilverbus.busroute.base.BaseMvpActivity
import com.quicksilverbus.busroute.model.Route
import kotlinx.android.synthetic.main.activity_route_list.*

class RouteDetailsActivity : BaseMvpActivity<RouteDetailsContract.View, RouteDetailsContract.Presenter>(), RouteDetailsContract.View {

    companion object {
        const val EXTRA_ROUTE = "ROUTE"
    }

    override var mPresenter: RouteDetailsContract.Presenter = RouteDetailsPresenter()

    // ==========================================================================================
    // LIFECYCLE
    // ==========================================================================================

    override fun getLayout() = R.layout.activity_route_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter.getRoutes()
    }

    // ==========================================================================================
    // SETUP
    // ==========================================================================================



    // ==========================================================================================
    // ACTIONS
    // ==========================================================================================

    private fun onRouteClick(view: View, route: Route) {
//        val intent = Intent(activity, MovieDetailsActivity::class.java)
//        intent.putExtra(MovieDetailsActivity.EXTRA_MOVIE, movie)
//        startActivity(intent, options.toBundle())
    }


    // ==========================================================================================
    // VIEW
    // ==========================================================================================

    override fun showDetails() {

    }

}
