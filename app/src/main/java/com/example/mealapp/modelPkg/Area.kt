package com.example.mealapp.modelPkg

import com.google.gson.annotations.SerializedName


data class Area (

  @SerializedName("meals" ) var meals : ArrayList<Meals> = arrayListOf()

)