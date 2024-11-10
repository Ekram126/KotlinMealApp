package com.example.mealapp.servicePkg

import com.example.mealapp.interfacePkg.ICategory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object CategoryConnection {
    val url = ConnectionBaseUrl("")
val categoryRetro = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
    .baseUrl(url.baseUrl).build()
    val serviceCategories = categoryRetro.create(ICategory::class.java)
}