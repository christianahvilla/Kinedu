package com.werden.kinedu.ui.home

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.werden.kinedu.ui.article.ArticleFragment
import com.werden.kinedu.R
import com.werden.kinedu.di.component.DaggerHomeComponent
import com.werden.kinedu.di.module.HomeModule
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeContract.View {

    @Inject
    lateinit var presenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        injectDependency()

        presenter.attach(this)

        setSupportActionBar(toolBar)
    }

    override fun showTabHost() {
        var adapter = HomeViewPager(supportFragmentManager)
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)
    }

    private fun injectDependency() {
        val activityComponent = DaggerHomeComponent
            .builder()
            .homeModule(HomeModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(ArticleFragment.TAG)

        if (fragment == null) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

}
