package com.example.tae_kotlin_assessment_footy.model.ligues;

import com.google.gson.annotations.SerializedName

data class LiguesBase (

	@SerializedName("teams") val teams : List<Teams>
)