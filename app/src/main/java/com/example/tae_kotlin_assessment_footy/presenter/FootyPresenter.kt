package com.example.tae_kotlin_assessment_footy.presenter

import com.example.tae_kotlin_assessment_footy.common.Constants
import com.example.tae_kotlin_assessment_footy.network.FootyRequest
import com.example.tae_kotlin_assessment_footy.network.FootyRetrofitInstance
import retrofit2.Retrofit
import retrofit2.create

class FootyPresenter: BasePresenter<FootyView> (){
    override fun onViewAttached(view: FootyView) {
        super.onViewAttached(view)

        view.showLoading()

        val footyRequest = FootyRetrofitInstance().retrofitInstance.create(FootyRequest::class.java)
        val call = footyRequest.getId(Constants.BASE_URL_ID)
    }
}

interface FootyView:BasePresenter.View{
    fun showLoading()
    fun showClub()
}