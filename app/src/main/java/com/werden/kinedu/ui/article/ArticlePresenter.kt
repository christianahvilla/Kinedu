package com.werden.kinedu.ui.article

import com.werden.kinedu.api.ApiServiceInterface
import com.werden.kinedu.model.article.Articles
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ArticlePresenter: ArticleContract.Presenter {

    //private val subscriptions = CompositeDisposable()
    private lateinit var view: ArticleContract.View
    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()

    override fun loadData() {
        var subscribe = api.getArticles().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ listArticle: Articles? ->
                view.showProgress(false)
                listArticle?.let { view.loadDataSuccess(it) }
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage()
            })

        subscriptions.add(subscribe)
    }

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: ArticleContract.View) {
        this.view = view
    }
}