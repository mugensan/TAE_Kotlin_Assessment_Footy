package com.example.tae_kotlin_assessment_footy.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tae_kotlin_assessment_footy.R
import com.example.tae_kotlin_assessment_footy.common.inflate
import com.example.tae_kotlin_assessment_footy.common.loadImg
import com.example.tae_kotlin_assessment_footy.model.clublist.ClubsModel
import com.example.tae_kotlin_assessment_footy.model.clublist.Teams
import kotlinx.android.synthetic.main.footy_card_view.view.*


class FootyAdapter(private val clubsModel: ClubsModel, private val listener: onClubClick) :

    RecyclerView.Adapter<FootyCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootyCardViewHolder {

        val view: View = parent.inflate(R.layout.footy_card_view, false)
        return FootyCardViewHolder(view)
    }

    override fun getItemCount(): Int {

        return clubsModel.teams.size
    }

    override fun onBindViewHolder(holder: FootyCardViewHolder, position: Int) {


        holder.tv_club_name.text = clubsModel.teams[position].strTeam
        holder.overview.text = clubsModel.teams[position].strDescriptionEN
        holder.logo.loadImg(clubsModel.teams[position].strTeamBadge)
    }


}


class FootyCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(teams: Teams, listener: onClubClick) {
        itemView.setOnClickListener {
            listener.onClubClick(teams)
        }
    }

    val tv_club_name = view.tv_club_name
    val overview = view.tv_overview
    val logo = view.iv_imageView
}


interface onClubClick {
    fun onClubClick(teams: Teams)
}