package com.werden.kinedu.di.component

import com.werden.kinedu.di.module.ActivityModule
import com.werden.kinedu.ui.article.detailed.DetailedActivity
import com.werden.kinedu.ui.home.HomeActivity
import dagger.Component

/**
 * Component providing inject() methods for presenters.
 */
@Component(modules = [(ActivityModule::class)])
interface ActivityComponent {

    /**
     * Injects required dependencies into the specified Activity.
     * @param detailedActivity in which to inject the dependencies
     */
    fun inject(detailedActivity: DetailedActivity)

    /**
     * Injects required dependencies into the specified Activity.
     * @param homeActivity in which to inject the dependencies
     */
    fun inject(homeActivity: HomeActivity)
}