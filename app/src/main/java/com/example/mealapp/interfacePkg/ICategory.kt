package com.example.mealapp.interfacePkg

import com.example.mealapp.modelPkg.Category
import retrofit2.Response
import retrofit2.http.GET

interface ICategory {

    @GET("categories.php")
    suspend fun getAllCategories(): Response<Category>

}