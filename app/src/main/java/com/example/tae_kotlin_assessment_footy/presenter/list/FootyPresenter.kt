package com.example.tae_kotlin_assessment_footy.presenter.list

import android.util.Log
import com.example.tae_kotlin_assessment_footy.common.Constants
import com.example.tae_kotlin_assessment_footy.common.enqueue
import com.example.tae_kotlin_assessment_footy.model.clublist.ClubsModel
import com.example.tae_kotlin_assessment_footy.network.clubsnetwork.FootyRequest
import com.example.tae_kotlin_assessment_footy.network.clubsnetwork.FootyRetrofitInstance
import com.example.tae_kotlin_assessment_footy.presenter.details.BasePresenter

class FootyPresenter: BasePresenter<FootyView>(){
    override fun onViewAttached(view: FootyView) {
        super.onViewAttached(view)

        view.showLoading()

        val footyRequest = FootyRetrofitInstance()
            .retrofitInstance.create(FootyRequest::class.java)
        val call = footyRequest.getClubs(Constants.URL_LEAGUE)

        call.enqueue{
            onResponse ={
                clubRecord -> val clubRecordResult = clubRecord.body()
                Log.d("SHOWREC", clubRecordResult!!.teams[0].strTeam)
                view.showClubRec(clubRecordResult)
            }
            onFailure = {
                Log.d("FAILURE", it?.message)}
        }
    }
}

interface FootyView: BasePresenter.View{
    fun showLoading()
    fun showClubRec(clubsModel:ClubsModel)
}