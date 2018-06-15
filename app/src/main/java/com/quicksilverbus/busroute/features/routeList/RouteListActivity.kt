package com.quicksilverbus.busroute.features.routeList

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.quicksilverbus.busroute.App
import com.quicksilverbus.busroute.R
import com.quicksilverbus.busroute.base.BaseMvpActivity
import com.quicksilverbus.busroute.features.routeDetails.RouteDetailsActivity
import com.quicksilverbus.busroute.model.Route
import kotlinx.android.synthetic.main.route_list_activity.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class RouteListActivity : BaseMvpActivity<RouteListContract.View>(), RouteListContract.View {

    @Inject
    lateinit var mPresenter: RouteListPresenter

    private lateinit var mRoutesAdapter: RoutesAdapter

    // ==========================================================================================
    // LIFECYCLE
    // ==========================================================================================

    init {
        App.appComponent().inject(this)
    }

    override fun getLayout() = R.layout.route_list_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupToolbar()
        setupRecyclerView()
        setupSwipeRefresh()
        mPresenter.getRoutes()
    }

    override fun onActivityInjected() {
        mPresenter.attachView(this)
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

    private fun setupSwipeRefresh() {
        routeSwipeRefreshLayout.setOnRefreshListener {
            mPresenter.getRoutes()
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
        routeSwipeRefreshLayout.isRefreshing = true
    }

    override fun dismissLoading() {
        routeSwipeRefreshLayout.isRefreshing = false
    }

    override fun displayRoutes(routes: List<Route>) {
        mRoutesAdapter.clear()
        mRoutesAdapter.add(routes)
    }

    override fun emptyList() {
        noRoutesAvailableTextView.visibility = View.VISIBLE
    }

    override fun showNoConnection() {
        showMessage(R.string.error_no_connection)
    }
}
