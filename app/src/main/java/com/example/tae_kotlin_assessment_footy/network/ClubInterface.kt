package com.example.tae_kotlin_assessment_footy.network

import android.content.Intent
import com.example.tae_kotlin_assessment_footy.common.Constants
import com.example.tae_kotlin_assessment_footy.model.clubdetails.DetailedClubRecord
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ClubInterface {

    @GET("lookupteam.php")
    fun getClubDetails(@Query("id")club_id : Int): Call<DetailedClubRecord>

    fun getClubId():Int{
        var intent: Intent? = null
        return intent!!.getIntExtra(Constants.MY_MESS,3)
    }
}