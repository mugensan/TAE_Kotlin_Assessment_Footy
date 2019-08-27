package com.example.tae_kotlin_assessment_footy.network.clubsnetwork

import com.example.tae_kotlin_assessment_footy.model.clubdetails.DetailedClubRecord
import com.example.tae_kotlin_assessment_footy.model.clublist.ClubsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FootyRequest {

    @GET("search_all_teams.php")
    fun getClubs(@Query("l")league:String):Call<ClubsModel>

//    https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id=
//    @GET("{idTeam}")
//    fun getLeague(@Path("idTeam")club_id : Int)
}