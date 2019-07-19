package com.werden.kinedu.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.werden.kinedu.R
import com.werden.kinedu.di.component.DaggerActivityComponent
import com.werden.kinedu.di.module.ActivityModule
import kotlinx.android.synthetic.main.tab_layout.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import kotlinx.android.synthetic.main.view_pager.*
import javax.inject.Inject
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.spinner_filter.*


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
        val adapter = HomeViewPager(supportFragmentManager)
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)

        tab_layout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                if(position == 0) {
                    spinner_filter_articles.visibility = View.GONE
                    spinner_filter_activities.visibility = View.VISIBLE
                    spinner_filter_articles.isEnabled = false
                    spinner_filter_activities.isEnabled = true

                }
                else{
                    spinner_filter_articles.visibility = View.VISIBLE
                    spinner_filter_activities.visibility = View.GONE
                    spinner_filter_articles.isEnabled = true
                    spinner_filter_activities.isEnabled = false
                }
            }
        })
    }


    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent
            .builder()
            .activityModule(ActivityModule(this))
            .build()
        activityComponent.inject(this)
    }


}
