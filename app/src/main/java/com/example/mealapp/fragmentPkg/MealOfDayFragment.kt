package com.example.mealapp.fragmentPkg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealapp.R
import com.example.mealapp.adapterPkg.AreaAdapt
import com.example.mealapp.modelPkg.Area
import com.example.mealapp.modelPkg.Meal
import com.example.mealapp.servicePkg.AreaConnection
import com.example.mealapp.servicePkg.IngredientConnection
import com.example.mealapp.servicePkg.MealOfDayConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class MealOfDayFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewMOD = inflater.inflate(R.layout.fragment_meal_of_day, container, false)

        lifecycleScope.launch {
            var result : Response<Meal>
            withContext(Dispatchers.IO) {
                result=   MealOfDayConnection.serviceMealOfDay.getMealOfDay()

            }
             var  thumb: ImageView =viewMOD.findViewById(R.id.imageView)
             var  mealName :TextView=viewMOD.findViewById(R.id.txtMealName)
            var  area :TextView=viewMOD.findViewById(R.id.tvArea)

            var  txtCategory :TextView=viewMOD.findViewById(R.id.tvCategory)


            val randomMeal = result.body()?.meals
            println(randomMeal)
            mealName.text =     randomMeal?.get(0)?.strMeal.toString()
            area.text =     randomMeal?.get(0)?.strArea.toString()
            txtCategory.text =     randomMeal?.get(0)?.strCategory.toString()
            Glide.with(requireActivity()).load(randomMeal?.get(0)?.strMealThumb).into(thumb)
        }
return viewMOD


    }


}