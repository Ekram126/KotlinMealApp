package com.example.mealapp.interfacePkg

import com.example.mealapp.modelPkg.Ingredient
import retrofit2.Response
import retrofit2.http.GET

interface IIngredient {

    @GET("list.php?i=list")
    suspend fun getAllIngredients(): Response<Ingredient>
}