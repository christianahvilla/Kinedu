package com.werden.kinedu.base

import android.view.View
import com.werden.kinedu.di.component.PresenterInjector
import com.werden.kinedu.di.module.ApiModule
import com.werden.kinedu.di.module.ContextModule
import com.werden.kinedu.ui.crawling.article.ArticlePresenter

abstract class BasePresenter<out V: BaseView>(protected  val view: View) {
    private val injector: PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(ApiModule)
        .build()

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated(){}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed(){}

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is ArticlePresenter -> injector.inject(this)
        }
    }

}