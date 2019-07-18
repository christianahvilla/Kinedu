package com.werden.kinedu.ui.article.detailed

import com.werden.kinedu.model.detailed.Detailed
import com.werden.kinedu.ui.base.BaseContract

class DetailedContract {

    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(detailed: Detailed)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadData(id: Int)
    }
}