package com.example.tae_kotlin_assessment_footy.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tae_kotlin_assessment_footy.R
import com.example.tae_kotlin_assessment_footy.common.Constants
import com.example.tae_kotlin_assessment_footy.common.enqueue
import com.example.tae_kotlin_assessment_footy.common.loadImg
import com.example.tae_kotlin_assessment_footy.network.ClubInterface
import com.example.tae_kotlin_assessment_footy.network.ClubRetrofitInstance
import kotlinx.android.synthetic.main.detail_club_layout.*

class FootyDetailsInfoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_club_layout)

        val clubId = intent.getIntExtra(Constants.MY_MESS,3)
        val clubInterface  = ClubRetrofitInstance().retrofitInstance.create(ClubInterface::class.java)

        val call = clubInterface.getClubDetails(clubId)
        call.enqueue{
            onResponse = {
                clubDetailsInfo -> val clubDetails = clubDetailsInfo.body()
                Log.d("LOGGINGCLUBDETAILS", clubDetails!!.teams[0].strTeam)
                tv_club_name.text = clubDetails.teams[0].strLeague
                tv_show_overview.text = clubDetails.teams[0].strDescriptionEN
                iv_show_logo.loadImg(clubDetails.teams[0].strTeamBadge)
            }
            onFailure = {
//                error -> Log.d("error",error?.message)
            }
        }
    }
}