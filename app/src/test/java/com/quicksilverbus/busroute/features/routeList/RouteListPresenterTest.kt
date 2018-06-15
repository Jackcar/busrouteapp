package com.quicksilverbus.busroute.features.routeList

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.quicksilverbus.busroute.data.RoutesRepository
import com.quicksilverbus.busroute.data.remote.model.RouteResponse
import io.reactivex.Observable
import org.junit.After
import org.junit.Before
import org.junit.Test

class RouteListPresenterTest {

    private val mView: RouteListContract.View = mock()
    private val mRoutesRepository: RoutesRepository = mock()
    private lateinit var mPresenter: RouteListPresenter

    @Before
    fun setup() {
        mPresenter = RouteListPresenter()
        mPresenter.attachView(mView)
    }

    @Test
    fun testGetRoutesSuccess() {
        val mockedResponse : RouteResponse = mock()

        doReturn(Observable.just(mockedResponse))
                .`when`(mRoutesRepository)
                .routes()

    }


    @After
    fun finish() {
        mPresenter.detachView()
    }
}