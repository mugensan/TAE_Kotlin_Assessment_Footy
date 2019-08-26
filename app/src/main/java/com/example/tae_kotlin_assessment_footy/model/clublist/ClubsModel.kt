package com.example.tae_kotlin_assessment_footy.model.clublist

import com.google.gson.annotations.SerializedName

data class ClubsModel (

	@SerializedName("teams") val teams : List<Teams>
)