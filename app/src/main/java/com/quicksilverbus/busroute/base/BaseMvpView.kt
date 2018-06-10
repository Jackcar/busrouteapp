package com.quicksilverbus.busroute.base

import android.content.Context
import android.support.annotation.StringRes

interface BaseMvpView {

    fun context(): Context

    fun showMessage(@StringRes srtResId: Int)

    fun showMessage(message: String)

}