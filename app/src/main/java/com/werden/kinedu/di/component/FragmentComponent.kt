package com.werden.kinedu.di.component

import com.werden.kinedu.di.module.FragmentModule
import dagger.Component

/**
 * Component providing inject() methods for presenters.
 */
@Component(modules = [FragmentModule::class])
interface FragmentComponent {

    /**
     * Injects required dependencies into the specified Fragment.
     * @param activityFragment in which to inject the dependencies
     */
    fun inject(activityFragment: ActivityFragment)

    /**
     * Injects required dependencies into the specified Fragment.
     * @param articleFragment in which to inject the dependencies
     */
    fun inject(articleFragment: ArticleFragment)

}