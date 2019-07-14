package com.werden.kinedu.di.scope

import javax.inject.Qualifier

/**
 * Retention means could be inspected in run time
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PerApplication