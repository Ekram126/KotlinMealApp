package com.example.mealapp.interfacePkg

import com.example.mealapp.modelPkg.Meal
import retrofit2.Response
import retrofit2.http.GET

interface IMealOfDay {

    @GET("random.php")
  //  fun getMealOfDay(): Response<Meal>
   suspend fun getMealOfDay(): Response<Meal>
}