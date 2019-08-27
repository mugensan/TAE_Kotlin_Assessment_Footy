package com.example.tae_kotlin_assessment_footy.view.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tae_kotlin_assessment_footy.R
import com.example.tae_kotlin_assessment_footy.common.Constants
import com.example.tae_kotlin_assessment_footy.common.showToast
import com.example.tae_kotlin_assessment_footy.model.clublist.ClubsModel
import com.example.tae_kotlin_assessment_footy.model.clublist.Teams
import com.example.tae_kotlin_assessment_footy.presenter.list.FootyPresenter
import com.example.tae_kotlin_assessment_footy.presenter.list.FootyView
import com.example.tae_kotlin_assessment_footy.view.details.FootyDetailsInfoActivity
import kotlinx.android.synthetic.main.list_club_recycler_view.*

class FootyList : AppCompatActivity(),
    FootyView {

    val presenter: FootyPresenter =
        FootyPresenter()

    override fun showLoading() {
        showToast(this, "loading")
//        pb_to.visibility = View.VISIBLE
    }

//    override fun showClubRec(clubsModel: ClubsModel) {
//        showToast(this, "completed")
//    }



    override fun showClubRec(clubsModel: ClubsModel) {

//        pb_to.visibility = View.GONE

        val adapter: FootyAdapter =
            FootyAdapter(clubsModel!!,
                object :
                    onClubClick {
                    override fun onClubClick(teams: Teams) {
                        val intent = Intent(
                            this@FootyList, FootyDetailsInfoActivity::class.java
                        )
                        intent.putExtra(Constants.MY_MESS, teams.idTeam)
                        startActivity(intent)

                    }
                }
            )

        rv_club_list.layoutManager = LinearLayoutManager(this@FootyList)
        rv_club_list.adapter = adapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_club_recycler_view)
        presenter.onViewAttached(this)
    }
}


