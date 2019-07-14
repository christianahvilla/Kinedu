package com.werden.kinedu.di.module

import com.werden.kinedu.api.ApiServiceInterface
import dagger.Module
import dagger.Provides

/**
 * Module which provides all required dependencies about Fragment
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
class FragmentModule {

    /**
     * Provides the Activities Fragment
     * @return the ActivityPresenter to provided
     */
    @Provides
    fun provideActivityPresenter(): ActivityContract.Presenter {
        return ActivityPresnser()
    }

    /**
     * Provides the Articles Fragment
     * @return the ArticlePresenter to provided
     */
    @Provides
    fun provideArticlePresenter(): ArticleContract.Presenter {
        return ArticlePresenter()
    }

    /**
     * Provides the HTTP connections for fragments
     * @return the ApiService to provided
     */
    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }

}