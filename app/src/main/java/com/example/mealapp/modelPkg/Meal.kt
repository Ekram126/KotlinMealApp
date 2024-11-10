package com.example.mealapp.modelPkg

import com.google.gson.annotations.SerializedName
import java.util.ArrayList


data class Meal (
  @SerializedName("meals" ) var meals : ArrayList<Meals> = arrayListOf()
)
