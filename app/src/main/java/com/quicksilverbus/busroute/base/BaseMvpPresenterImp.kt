package com.quicksilverbus.busroute.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseMvpPresenterImpl<V : BaseMvpView> : BaseMvpPresenter<V> {
    private var mDisposable = CompositeDisposable()
    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
        mDisposable.clear()
    }

    override fun add(disposable: Disposable) {
        mDisposable.add(disposable)
    }

}