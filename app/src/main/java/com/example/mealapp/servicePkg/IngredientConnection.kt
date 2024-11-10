package com.example.mealapp.servicePkg

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.mealapp.interfacePkg.IIngredient

object IngredientConnection {

    val url = ConnectionBaseUrl("")
    val ingredientRetro = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url.baseUrl).build()
    val serviceIngredients= ingredientRetro.create(IIngredient::class.java)
}