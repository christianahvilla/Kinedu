package com.werden.kinedu.ui.article

import com.werden.kinedu.model.article.Articles
import com.werden.kinedu.ui.base.BaseContract

class ArticleContract {

    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage()
        fun loadDataSuccess(list: Articles)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadData()
    }

}