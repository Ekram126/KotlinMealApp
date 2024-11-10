package com.example.mealapp.interfacePkg

import com.example.mealapp.modelPkg.Area
import com.example.mealapp.modelPkg.Category
import retrofit2.Response
import retrofit2.http.GET

interface IArea {

    @GET("list.php?a=list")
    suspend fun getAllArea(): Response<Area>

}