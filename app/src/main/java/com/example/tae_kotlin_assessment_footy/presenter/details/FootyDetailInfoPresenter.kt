package com.example.tae_kotlin_assessment_footy.presenter.details

import android.content.Intent
import com.example.tae_kotlin_assessment_footy.common.Constants
import com.example.tae_kotlin_assessment_footy.model.clubdetails.DetailedClubRecord
import com.example.tae_kotlin_assessment_footy.presenter.list.FootyDetailInfoBasePresenter

class FootyDetailInfoPresenter :
    FootyDetailInfoBasePresenter<FootyDetailInfoPresenter.ClubDetailedView>() {

//    showLoading()
//    val getClubId =

    fun getClubId(): Int {
        var intent: Intent? = null
        return intent!!.getIntExtra(Constants.MY_MESS, 3)

//    val intent = Intent()
//    val receiveId = intent.getIntExtra(Constants.MY_MESS,3)
    }


    interface ClubDetailedView :
        FootyDetailInfoBasePresenter.View {
        fun showLoading()
        fun showClubRec(clubsModel: DetailedClubRecord?)
    }
}