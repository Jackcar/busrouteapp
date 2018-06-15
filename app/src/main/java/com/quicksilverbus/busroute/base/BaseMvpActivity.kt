package com.quicksilverbus.busroute.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseMvpActivity<in V : BaseMvpView>
    : AppCompatActivity(), BaseMvpView {

    private var mPresenter: BaseMvpPresenter<V>? = null

    abstract fun getLayout(): Int

    abstract fun onActivityInjected()

    // ==========================================================================================
    // LIFECYCLE
    // ==========================================================================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        onActivityInjected()

        setupToolbar()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
    }

    // ==========================================================================================
    // ACTION
    // ==========================================================================================

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        android.R.id.home -> consume { supportFinishAfterTransition() }
        else -> super.onOptionsItemSelected(item)
    }

    // ==========================================================================================
    // SETUP
    // ==========================================================================================

    private fun setupToolbar() {
        toolbar.let {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowTitleEnabled(true)
        }
    }

    // ==========================================================================================
    // HELPER
    // ==========================================================================================

    override fun context(): Context = this

    override fun showMessage(srtResId: Int) {
        Toast.makeText(this, srtResId, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    inline fun consume(f: () -> Unit): Boolean {
        f()
        return true
    }
}