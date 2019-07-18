package com.werden.kinedu.ui.article.detailed

import com.werden.kinedu.api.ApiServiceInterface
import com.werden.kinedu.model.detailed.Detailed
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailedPresenter: DetailedContract.Presenter {

    private lateinit var view: DetailedContract.View
    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()


    override fun loadData(id: Int) {
        val subscribe = api.getArticleDetailed(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ detailed: Detailed ->
                view.showProgress(false)
                view.loadDataSuccess(detailed)
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            })

        subscriptions.add(subscribe)
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: DetailedContract.View) {
        this.view = view
    }
}