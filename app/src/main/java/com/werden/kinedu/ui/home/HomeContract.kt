package com.werden.kinedu.ui.home

import com.werden.kinedu.ui.base.BaseContract

class HomeContract {

    interface View: BaseContract.View{
        fun showActivityFragment()
        fun showArticleFragment()
    }

    interface Presenter: BaseContract.Presenter<HomeContract.View> {
    }

}