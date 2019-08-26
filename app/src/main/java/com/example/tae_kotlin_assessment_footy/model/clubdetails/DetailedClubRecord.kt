package com.example.tae_kotlin_assessment_footy.model.clubdetails

import com.google.gson.annotations.SerializedName

data class DetailedClubRecord (

	@SerializedName("teams") val teams : List<TeamsDetail>
)