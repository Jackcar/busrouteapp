package com.quicksilverbus.busroute.features.routeDetails

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.quicksilverbus.busroute.App
import com.quicksilverbus.busroute.R
import com.quicksilverbus.busroute.base.BaseMvpActivity
import com.quicksilverbus.busroute.model.Route
import com.quicksilverbus.busroute.util.Utils
import kotlinx.android.synthetic.main.route_details_activity.*
import javax.inject.Inject

class RouteDetailsActivity : BaseMvpActivity<RouteDetailsContract.View>(), RouteDetailsContract.View {

    companion object {
        const val EXTRA_ROUTE = "ROUTE"
    }

    @Inject
    lateinit var mPresenter: RouteDetailsPresenter

    private lateinit var mStopsAdapter: StopsAdapter

    // ==========================================================================================
    // LIFECYCLE
    // ==========================================================================================

    init {
        App.appComponent().inject(this)
    }

    override fun getLayout() = R.layout.route_details_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the requested route
        val route = intent.getSerializableExtra(EXTRA_ROUTE) as Route

        setupRecyclerView()
        showRouteDetails(route)
    }

    override fun onActivityInjected() {
        mPresenter.attachView(this)
    }

    // ==========================================================================================
    // SETUP
    // ==========================================================================================

    private fun setupRecyclerView() {
        // Set adapter to recycler view
        mStopsAdapter = StopsAdapter(ArrayList(0))

        with(stopsRecyclerView) {
            // Setup layout manager
            layoutManager = LinearLayoutManager(context())
            adapter = mStopsAdapter
        }
    }

    // ==========================================================================================
    // ACTIONS
    // ==========================================================================================


    // ==========================================================================================
    // VIEW
    // ==========================================================================================

    override fun showRouteDetails(route: Route) {
        routeNameTextView.text = route.name
        routeDescriptionTextView.text = route.description
        accessibilityImageView.visibility = if (route.accessible) View.VISIBLE else View.INVISIBLE

        Utils.loadImage(route.image, this, routeImageView, R.drawable.ic_bus)

        mStopsAdapter.add(route.stops)
    }

}
