package com.quicksilverbus.busroute.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Utils {
    companion object {
        @JvmStatic
        fun loadImage(url: String?, context: Context, imageView: ImageView) {
            url.let {
                val options = RequestOptions().centerCrop()
                Glide.with(context)
                        .load(url)
                        .apply(options)
                        .into(imageView)
            }
        }
    }
}