package com.example.tae_kotlin_assessment_footy.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FootyRequest {

    @GET()


    @GET("{idTeam}")
    fun getId(@Path("idTeam")club_id : Int)
}