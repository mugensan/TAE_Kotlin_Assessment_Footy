package com.example.tae_kotlin_assessment_footy.presenter.details

import androidx.annotation.CallSuper


abstract class BasePresenter<T : BasePresenter.View> {

    var view: T? = null



    @CallSuper
    open fun onViewAttached(view: T) {
        if (this.view != null) {
            throw IllegalStateException("View is already attached!")
        } else {
            this.view = view
        }
    }

    interface View
}