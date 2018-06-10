package com.quicksilverbus.busroute.base

import io.reactivex.disposables.Disposable

interface BaseMvpPresenter<in V : BaseMvpView> {

    fun attachView(view: V)

    fun detachView()

    fun add(disposable: Disposable)

}