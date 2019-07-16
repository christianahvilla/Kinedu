package com.werden.kinedu.di.component

import com.werden.kinedu.di.module.HomeModule
import com.werden.kinedu.ui.home.HomeActivity
import dagger.Component

/**
 * Component providing inject() methods for presenters.
 */
@Component(modules = [(HomeModule::class)])
interface HomeComponent {
    /**
     * Injects required dependencies into the specified Activity.
     * @param homeActivity in which to inject the dependencies
     */
    fun inject(homeActivity: HomeActivity)

}