package com.example.mealapp.adapterPkg

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealapp.R
import com.example.mealapp.modelPkg.Meal

class MealCategoryAdapt(val data : Meal, val context: Context):
    RecyclerView.Adapter<MealCategoryAdapt.ViewHolder>() {

    class ViewHolder (val myView: View):RecyclerView.ViewHolder(myView){
        val mealView : ConstraintLayout = myView.findViewById(R.id.myMealView)
        val txtMealName : TextView = myView.findViewById(R.id.tvmealName)
        val txtMealArea : TextView = myView.findViewById(R.id.tvmealArea)
        val mealThumb: ImageView = myView.findViewById(R.id.imgMeal)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealCategoryAdapt.ViewHolder {
        val inflater= LayoutInflater.from(parent.context).inflate(R.layout.mealitem,parent,false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return data.meals.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtMealName.text = data.meals[position].strMeal
        holder.txtMealArea.text = data.meals[position].strArea

        Glide.with(context).load(data.meals[position].strMealThumb).into(holder.mealThumb)


}
}