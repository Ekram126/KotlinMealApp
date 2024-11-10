package com.example.mealapp.servicePkg

import com.example.mealapp.interfacePkg.IArea
import com.example.mealapp.interfacePkg.ICategory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object AreaConnection {
    val url = ConnectionBaseUrl("")
val areaRetro = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
    .baseUrl(url.baseUrl).build()
    val areaService = areaRetro.create(IArea::class.java)
}