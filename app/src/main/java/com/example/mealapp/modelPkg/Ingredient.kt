package com.example.mealapp.modelPkg

import com.google.gson.annotations.SerializedName

data class Ingredient(  @SerializedName("meals" ) var meals : ArrayList<Meals> = arrayListOf()
)
