package com.quicksilverbus.busroute.features.routeList

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.quicksilverbus.busroute.data.RoutesRepository
import com.quicksilverbus.busroute.data.remote.model.RouteResponse
import io.reactivex.Observable
import org.junit.After
import org.junit.Before
import org.junit.Test

class RouteListPresenterTest {

    private val mView: RouteListContract.View = mock()
    private var mRoutesRepository: RoutesRepository = mock()
    private var mPresenter: RouteListPresenter = mock()

    @Before
    fun setup() {
        mPresenter.attachView(mView)
    }

    @Test
    fun testGetRoutesSuccess() {
        val mockedResponse : RouteResponse = mock()

        doReturn(Observable.just(mockedResponse))
                .`when`(mRoutesRepository)
                .routes()

        mPresenter.getRoutes()

        verify(mView).showLoading()
        verify(mView).dismissLoading()
        verify(mView).displayRoutes(mockedResponse.routes)
    }


    @After
    fun tearDown() {
        mPresenter.detachView()
    }
}