package com.example.tae_kotlin_assessment_footy.presenter.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tae_kotlin_assessment_footy.R
import com.example.tae_kotlin_assessment_footy.common.Constants
import com.example.tae_kotlin_assessment_footy.common.enqueue
import com.example.tae_kotlin_assessment_footy.common.loadImg
import com.example.tae_kotlin_assessment_footy.model.clubdetails.DetailedClubRecord
import com.example.tae_kotlin_assessment_footy.model.clublist.ClubsModel
import com.example.tae_kotlin_assessment_footy.network.detailsnetwork.ClubInterface
import com.example.tae_kotlin_assessment_footy.network.detailsnetwork.ClubRetrofitInstance
import kotlinx.android.synthetic.main.detail_club_layout.*


class DetailsPresenter : BasePresenter<FootyDetailView>() {
    //presenter
    override fun onViewAttached(view: FootyDetailView) {
        super.onViewAttached(view)
        val clubId = view.getTeamId()

        //        val clubId = getClubId(Constants.MY_MESS)
        val clubInterface = ClubRetrofitInstance()
            .retrofitInstance.create(ClubInterface::class.java)
        val call = clubInterface.getClubDetails(clubId)
        call.enqueue {
            onResponse = {

//                clubId -> val clubId = clubId.body()
                    clubDetailsInfo ->
                val clubDetails = clubDetailsInfo.body()

                view.showClubRec(clubDetails)
//                Log.d("LOGGINGCLUBDETAILS", clubDetails!!.teams[0].strTeam)
//                tv_club_name.text = clubDetails.teams[0].strLeague
//                tv_show_overview.text = clubDetails.teams[0].strDescriptionEN
//                iv_show_logo.loadImg(clubDetails.teams[0].strTeamBadge)
            }
            onFailure = {
                 error -> Log.d("error",error?.message)
            }
        }
    }
}

interface FootyDetailView : BasePresenter.View {
    fun showLoading()
    fun showClubRec(clubsModel: DetailedClubRecord?)
    fun getTeamId(): Int
}

//fun getClubId(view: View){
//    val ClubId = view(getClubId(Constants.BASE_URL_SEARCH_BY_ID))
//}