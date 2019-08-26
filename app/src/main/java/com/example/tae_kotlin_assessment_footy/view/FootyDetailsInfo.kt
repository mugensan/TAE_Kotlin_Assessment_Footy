package com.example.tae_kotlin_assessment_footy.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tae_kotlin_assessment_footy.R
import com.example.tae_kotlin_assessment_footy.common.Constants
import com.example.tae_kotlin_assessment_footy.common.showToast
import com.example.tae_kotlin_assessment_footy.model.clubdetails.DetailedClubRecord
import com.example.tae_kotlin_assessment_footy.model.clublist.ClubsModel
import com.example.tae_kotlin_assessment_footy.model.clublist.Teams
import com.example.tae_kotlin_assessment_footy.presenter.ClubDetailedView
import com.example.tae_kotlin_assessment_footy.presenter.FootyDetailInfoBasePresenter
import com.example.tae_kotlin_assessment_footy.presenter.FootyPresenter
import com.example.tae_kotlin_assessment_footy.presenter.FootyView
import kotlinx.android.synthetic.main.list_club_recycler_view.*
import kotlinx.android.synthetic.main.sorting_paradigm_layout.*

class FootyDetailsInfo: AppCompatActivity() , FootyView {
    override fun showLoading() {
        showToast(this,"loading")

    }

    override fun showClubRec(clubsModel: DetailedClubRecord?) {
        showToast(this,"completed")    }

    val presenter:FootyPresenter = FootyPresenter()

    fun showClubRec(clubsModel: ClubsModel){

    val adapter: FootyAdapter =
        FootyAdapter(clubsModel,object:
        onClubClick{
            override fun onClubClick(teams: Teams) {
                val intent = Intent(this@FootyDetailsInfo,FootyDetailsInfoActivity::class.java)
                intent.putExtra(Constants.MY_MESS,teams.idTeam)
                startActivity(intent)

            }
        }
        )

        rv_club_list.layoutManager = LinearLayoutManager(this@FootyDetailsInfo)
        rv_club_list.adapter = adapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_club_recycler_view)

        presenter.onViewAttached(this)
    }
}

