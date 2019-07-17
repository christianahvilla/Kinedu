package com.werden.kinedu.ui.home

import com.werden.kinedu.ui.base.BaseContract

class HomeContract {

    interface View: BaseContract.View{
        //fun showActivityFragment()
        //fun showArticleFragment()
        fun showTabHost()
    }

    interface Presenter: BaseContract.Presenter<HomeContract.View> {
    }

}