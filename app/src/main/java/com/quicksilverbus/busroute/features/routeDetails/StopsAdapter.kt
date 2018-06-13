package com.quicksilverbus.busroute.features.routeDetails

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quicksilverbus.busroute.R
import com.quicksilverbus.busroute.model.Route
import kotlinx.android.synthetic.main.stop_list_item.view.*

class StopsAdapter : RecyclerView.Adapter<StopsAdapter.ViewHolder> {

    companion object {
        private val VIEW_TYPE_TOP = 0
        private val VIEW_TYPE_MIDDLE = 1
        private val VIEW_TYPE_BOTTOM = 2
    }

    private lateinit var mRoutes: MutableList<Route>

    constructor(stops: List<Route>) {
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

    override fun getItemViewType(position: Int): Int {
        if (position == mRoutes.size - 1) return VIEW_TYPE_BOTTOM
        else if (position == 0) return VIEW_TYPE_TOP

        return VIEW_TYPE_MIDDLE
    }

    override fun getItemCount() = mRoutes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.stop_list_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(mRoutes[position], holder.itemViewType)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(route: Route, itemViewType: Int) = with(itemView) {
            stopNameTextView.text = route.name

            if (itemViewType == VIEW_TYPE_BOTTOM)
                line_ic.visibility = View.GONE
            else
                line_ic.visibility = View.VISIBLE
        }
    }
}