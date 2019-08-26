package com.example.tae_kotlin_assessment_footy.presenter

import android.content.Intent
import com.example.tae_kotlin_assessment_footy.common.Constants
import com.example.tae_kotlin_assessment_footy.common.Constants.Companion.MY_MESS
import com.example.tae_kotlin_assessment_footy.model.clubdetails.DetailedClubRecord
import com.example.tae_kotlin_assessment_footy.network.ClubInterface

class FootyDetailInfoPresenter : FootyDetailInfoBasePresenter<ClubDetailedView>(){

//    showLoading()
    val intent = Intent()
    val receiveId = intent.getIntExtra(Constants.MY_MESS,3)
}




interface ClubDetailedView:FootyDetailInfoBasePresenter.View{
    fun showLoading()
    fun showClubRec(clubsModel: DetailedClubRecord?)
}