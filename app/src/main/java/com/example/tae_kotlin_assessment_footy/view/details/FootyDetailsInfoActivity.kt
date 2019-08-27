package com.example.tae_kotlin_assessment_footy.view.details

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tae_kotlin_assessment_footy.R
import com.example.tae_kotlin_assessment_footy.common.Constants
import com.example.tae_kotlin_assessment_footy.common.enqueue
import com.example.tae_kotlin_assessment_footy.common.loadImg
import com.example.tae_kotlin_assessment_footy.common.showToast
import com.example.tae_kotlin_assessment_footy.model.clubdetails.DetailedClubRecord
import com.example.tae_kotlin_assessment_footy.model.clubdetails.TeamsDetail
import com.example.tae_kotlin_assessment_footy.model.clublist.ClubsModel
import com.example.tae_kotlin_assessment_footy.model.clublist.Teams
import com.example.tae_kotlin_assessment_footy.network.detailsnetwork.ClubInterface
import com.example.tae_kotlin_assessment_footy.network.detailsnetwork.ClubRetrofitInstance
import com.example.tae_kotlin_assessment_footy.presenter.details.BasePresenter
import com.example.tae_kotlin_assessment_footy.presenter.details.DetailsPresenter
import com.example.tae_kotlin_assessment_footy.presenter.details.FootyDetailInfoPresenter
import com.example.tae_kotlin_assessment_footy.presenter.details.FootyDetailView
import com.example.tae_kotlin_assessment_footy.view.list.FootyAdapter
import com.example.tae_kotlin_assessment_footy.view.list.onClubClick
import kotlinx.android.synthetic.main.detail_club_layout.*

class FootyDetailsInfoActivity : AppCompatActivity(), FootyDetailView {

    val presenter: DetailsPresenter = DetailsPresenter()


   override fun getTeamId(): Int {

       return intent.getIntExtra(Constants.MY_MESS, 3)
   }



    override fun showLoading() {
        showToast(this, "loading")
        showLoading()
    }

    override fun showClubRec(clubsModel: DetailedClubRecord?) {




        tv_club_name.text = clubsModel!!.teams[0].idTeam.toString()
//        tv_show_overview.text = clubDetails.teams[0].strDescriptionEN
//        iv_show_logo.loadImg(clubDetails.teams[0].strTeamBadge)







    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_club_layout)

        presenter.onViewAttached(this)
    }
}

