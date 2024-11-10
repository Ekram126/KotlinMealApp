package com.example.mealapp.modelPkg

import com.google.gson.annotations.SerializedName


data class Category (

  @SerializedName("categories" ) var categories : ArrayList<Categories> = arrayListOf()

)