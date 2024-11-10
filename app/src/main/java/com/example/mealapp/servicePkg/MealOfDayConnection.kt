package com.example.mealapp.servicePkg


import com.example.mealapp.interfacePkg.IMealOfDay
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MealOfDayConnection {
    val url = ConnectionBaseUrl("")
    val modRetro = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url.baseUrl).build()
    val serviceMealOfDay = modRetro.create(IMealOfDay::class.java)
}