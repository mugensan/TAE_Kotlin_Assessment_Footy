package com.example.tae_kotlin_assessment_footy.model.arsenal

import com.google.gson.annotations.SerializedName


data class Clubs (

	@SerializedName("teams") val teams : List<Teams>
)