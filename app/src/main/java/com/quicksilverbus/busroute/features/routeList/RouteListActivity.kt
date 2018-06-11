package com.quicksilverbus.busroute.features.routeList

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.quicksilverbus.busroute.R
import com.quicksilverbus.busroute.base.BaseMvpActivity
import com.quicksilverbus.busroute.model.Route
import kotlinx.android.synthetic.main.activity_route_list.*

class RouteListActivity : BaseMvpActivity<RouteListContract.View, RouteListContract.Presenter>(), RouteListContract.View {
    override var mPresenter: RouteListContract.Presenter = RouteListPresenter()

    private lateinit var mRoutesAdapter: RoutesAdapter

    // ==========================================================================================
    // LIFECYCLE
    // ==========================================================================================

    override fun getLayout() = R.layout.activity_route_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//        setupRecyclerView()
//        mPresenter.getRoutes()
    }

    // ==========================================================================================
    // SETUP
    // ==========================================================================================

    private fun setupRecyclerView() {
        // Setup layout manager
        val linearLayoutManager = LinearLayoutManager(context())
        routeRecyclerView.layoutManager = linearLayoutManager

        // Set adapter to recycler view
        mRoutesAdapter = RoutesAdapter(ArrayList(0)) { view, route ->
            // Execute onClick
            onRouteClick(view, route)
        }
        routeRecyclerView.adapter = mRoutesAdapter
    }

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

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun displayRoutes(routes: List<Route>) {
//        mRoutesAdapter.add(routes)
    }

    override fun emptyList() {

    }

}
