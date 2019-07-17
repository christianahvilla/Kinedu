package com.werden.kinedu.ui.activity

import com.werden.kinedu.api.ApiServiceInterface
import com.werden.kinedu.model.activity.Activities
import com.werden.kinedu.model.activity.ActivityData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ActivityPresenter: ActivityContract.Presenter{

    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()
    private lateinit var view: ActivityContract.View


    override fun loadData() {
        var subscribe = api.getActivities().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ listActivity: Activities? ->
                view.showProgress(false)
                listActivity?.let { view.loadDataSuccess(it) }
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

    override fun attach(view: ActivityContract.View) {
        this.view = view
    }

}