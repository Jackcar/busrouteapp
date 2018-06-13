package com.quicksilverbus.busroute.features.routeDetails

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.quicksilverbus.busroute.R
import com.quicksilverbus.busroute.base.BaseMvpActivity
import com.quicksilverbus.busroute.features.routeList.RoutesAdapter
import com.quicksilverbus.busroute.model.Route
import com.quicksilverbus.busroute.util.Utils
import kotlinx.android.synthetic.main.route_details_activity.*

class RouteDetailsActivity : BaseMvpActivity<RouteDetailsContract.View, RouteDetailsContract.Presenter>(), RouteDetailsContract.View {

    companion object {
        const val EXTRA_ROUTE = "ROUTE"
    }

    override var mPresenter: RouteDetailsContract.Presenter = RouteDetailsPresenter()

    private lateinit var mStopsAdapter: StopsAdapter

    // ==========================================================================================
    // LIFECYCLE
    // ==========================================================================================

    override fun getLayout() = R.layout.route_details_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the requested route
        val route = intent.getSerializableExtra(EXTRA_ROUTE) as Route

        setupRecyclerView()
        mPresenter.showRouteDetails(route)
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

    override fun showTitle(title: String) {
        routeNameTextView.text = title
    }

    override fun showImage(imageUrl: String) {
        Utils.loadImage(imageUrl, this, routeImageView)
    }

    override fun showAccessible(accessible: Boolean) {
        accessibilityImageView.visibility = if (accessible) View.VISIBLE else View.INVISIBLE
    }

    override fun showDescription(description: String) {
        routeDescriptionTextView.text = description
    }

    override fun showStops(stops: List<Route>) {
        mStopsAdapter.add(stops)
    }


}
