package com.werden.kinedu.ui.activity

import com.werden.kinedu.model.activity.Activities
import com.werden.kinedu.ui.base.BaseContract

class ActivityContract {

    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: Activities)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadData()
    }

}