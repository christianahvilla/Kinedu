package com.werden.kinedu.ui.home

import com.werden.kinedu.ui.base.BaseContract

class HomeContract {

    interface View: BaseContract.View{
        fun showTabHost()
    }

    interface Presenter: BaseContract.Presenter<View> {
    }

}