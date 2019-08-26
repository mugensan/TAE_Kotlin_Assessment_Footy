package com.example.tae_kotlin_assessment_footy.presenter

import android.util.Log
import com.example.tae_kotlin_assessment_footy.common.Constants
import com.example.tae_kotlin_assessment_footy.common.enqueue
import com.example.tae_kotlin_assessment_footy.model.clubdetails.DetailedClubRecord
import com.example.tae_kotlin_assessment_footy.network.FootyRequest
import com.example.tae_kotlin_assessment_footy.network.FootyRetrofitInstance

class FootyPresenter: BasePresenter<FootyView> (){
    override fun onViewAttached(view: FootyView) {
        super.onViewAttached(view)

        view.showLoading()

        val footyRequest = FootyRetrofitInstance().retrofitInstance.create(FootyRequest::class.java)
        val call = footyRequest.getLeague(Constants.URL_LEAGUE)

        call.enqueue{
            onResponse = {
                RecClubs -> val historyRecClubs = RecClubs.body()
                Log.d("SHOWCLUBHISTORY",historyRecClubs!!.teams[0].strTeam)
//                showToast(this,"here is the history rec of clubs")
                view.showClubRec(historyRecClubs)
            }

//            onFailure = {
//                error -> Log.d ("Error message: ", error?.message)
//            }
        }
    }
}

interface FootyView:BasePresenter.View{
    fun showLoading()
    fun showClubRec(clubsModel: DetailedClubRecord?)
}