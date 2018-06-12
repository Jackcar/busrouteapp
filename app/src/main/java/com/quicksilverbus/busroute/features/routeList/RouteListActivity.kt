package com.quicksilverbus.busroute.features.routeList

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.quicksilverbus.busroute.R
import com.quicksilverbus.busroute.base.BaseMvpActivity
import com.quicksilverbus.busroute.features.routeDetails.RouteDetailsActivity
import com.quicksilverbus.busroute.model.Route
import kotlinx.android.synthetic.main.activity_route_list.*
import org.jetbrains.anko.startActivity

class RouteListActivity : BaseMvpActivity<RouteListContract.View, RouteListContract.Presenter>(), RouteListContract.View {
    override var mPresenter: RouteListContract.Presenter = RouteListPresenter()

    private lateinit var mRoutesAdapter: RoutesAdapter

    // ==========================================================================================
    // LIFECYCLE
    // ==========================================================================================

    override fun getLayout() = R.layout.activity_route_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupToolbar()
        setupRecyclerView()
        mPresenter.getRoutes()
    }

    // ==========================================================================================
    // SETUP
    // ==========================================================================================

    private fun setupToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    private fun setupRecyclerView() {
        // Set adapter to recycler view
        mRoutesAdapter = RoutesAdapter(ArrayList(0)) { view, route ->
            // Execute onClick
            onRouteClick(view, route)
        }

        with(routeRecyclerView) {
            // Setup layout manager
            layoutManager = LinearLayoutManager(context())
            adapter = mRoutesAdapter
        }
    }

    // ==========================================================================================
    // ACTIONS
    // ==========================================================================================

    private fun onRouteClick(view: View, route: Route) {
        startActivity<RouteDetailsActivity>(RouteDetailsActivity.EXTRA_ROUTE to route)
    }

    // ==========================================================================================
    // VIEW
    // ==========================================================================================

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun displayRoutes(routes: List<Route>) {
        mRoutesAdapter.add(routes)
    }

    override fun emptyList() {

    }

}
