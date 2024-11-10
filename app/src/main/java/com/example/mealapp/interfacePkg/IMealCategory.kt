package com.example.mealapp.interfacePkg

import com.example.mealapp.modelPkg.Meal
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IMealCategory {
    @GET("filter.php?c=:c")
    //suspend fun getMealByCategoryName(c: String): Response<Meal>
    suspend fun getMealByCategoryName(@Query("c") categoryName: String):  Response<Meal>

//    @Query("SELECT * FROM favs WHERE idMeal = :idMeal")
}