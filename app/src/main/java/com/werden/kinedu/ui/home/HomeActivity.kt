package com.werden.kinedu.ui.home

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

    /*
    override fun showActivityFragment() {
        if (supportFragmentManager.findFragmentByTag(ActivityFragment.TAG) == null) {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .setCustomAnimations(AnimType.FADE.getAnimPair().first, AnimType.FADE.getAnimPair().second)
                .replace(R.id.frame, ActivityFragment().newInstance(), ActivityFragment.TAG)
                .commit()
        }
    }

    override fun showArticleFragment() {
        supportFragmentManager.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(AnimType.SLIDE.getAnimPair().first, AnimType.SLIDE.getAnimPair().second)
            .replace(R.id.frame, ArticleFragment().newInstance(), ArticleFragment.TAG)
            .commit()
    }
    */

    override fun showTabHost() {
        val adapter = HomeViewPager(supportFragmentManager)
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


    enum class AnimType() {
        SLIDE,
        FADE;

        fun getAnimPair(): Pair<Int, Int> {
            return when(this) {
                SLIDE -> Pair(R.anim.slide_left, R.anim.slide_right)
                FADE -> Pair(R.anim.fade_in, R.anim.fade_out)
            }

            return Pair(R.anim.slide_left, R.anim.slide_right)
        }
    }
}
