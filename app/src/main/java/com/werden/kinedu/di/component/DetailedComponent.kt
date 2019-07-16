package com.werden.kinedu.di.component

import com.werden.kinedu.di.module.DetailedModule
import dagger.Component


/**
 * Component providing inject() methods for presenters.
 */
@Component(modules = [(DetailedModule::class)])
interface DetailedComponent {
    /**
     * Injects required dependencies into the specified Activity.
     * @param detailedActivity in which to inject the dependencies
     */
    //fun inject(detailedActivity: DetailedActivity)

}