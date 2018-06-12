package com.quicksilverbus.busroute.features.routeDetails

import android.os.Bundle
import android.view.View
import com.quicksilverbus.busroute.R
import com.quicksilverbus.busroute.base.BaseMvpActivity
import com.quicksilverbus.busroute.model.Route
import com.quicksilverbus.busroute.util.Utils
import kotlinx.android.synthetic.main.route_details_activity.*

class RouteDetailsActivity : BaseMvpActivity<RouteDetailsContract.View, RouteDetailsContract.Presenter>(), RouteDetailsContract.View {

    companion object {
        const val EXTRA_ROUTE = "ROUTE"
    }

    override var mPresenter: RouteDetailsContract.Presenter = RouteDetailsPresenter()

    // ==========================================================================================
    // LIFECYCLE
    // ==========================================================================================

    override fun getLayout() = R.layout.route_details_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the requested route
        val route = intent.getSerializableExtra(EXTRA_ROUTE) as Route

        mPresenter.showRouteDetails(route)
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
    }


}
