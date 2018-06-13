package com.quicksilverbus.busroute.features.routeList

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quicksilverbus.busroute.R
import com.quicksilverbus.busroute.model.Route
import com.quicksilverbus.busroute.util.Utils
import kotlinx.android.synthetic.main.route_list_item.view.*

class RoutesAdapter : RecyclerView.Adapter<RoutesAdapter.ViewHolder> {

    private lateinit var mRoutes: MutableList<Route>

    private var mListener: (View, Route) -> Unit

    constructor(stops: List<Route>, listener: (View, Route) -> Unit) {
        mListener = listener
        set(stops)
    }

    fun set(stops: List<Route>) {
        mRoutes = stops.toMutableList()
        notifyDataSetChanged()
    }

    fun add(stops: List<Route>) {
        mRoutes.addAll(stops)
        notifyDataSetChanged()
    }

    fun clear() {
        mRoutes.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount() = mRoutes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.route_list_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(mRoutes[position], mListener)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(route: Route, listener: (View, Route) -> Unit) = with(itemView) {
            routeNameTextView.text = route.name

            with(routeStopTextView) {
                if(route.stops.size > 1)
                    text = route.stops.size.toString() + " " + itemView.context.getString(R.string.route_list_activity_label_stops)
                else
                    text = route.stops.size.toString() + " "  + itemView.context.getString(R.string.route_list_activity_label_stop)
            }

            Utils.loadImage(route.image, rootView.context, routeImageView)

            setOnClickListener { listener(itemView, route) }
        }
    }
}