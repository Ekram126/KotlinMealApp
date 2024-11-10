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
import com.example.mealapp.modelPkg.Category
import com.example.mealapp.modelPkg.Meal
import com.example.mealapp.servicePkg.MealCategoryConnection
import kotlinx.coroutines.Dispatchers
import com.example.mealapp.fragmentPkg.MealFragment
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import androidx.lifecycle.lifecycleScope

interface CategoryListener {
    fun onItemClicked(categoryName:String)
}
class CategoryAdapt (val data : Category, val context:Context,private val listener: CategoryListener):
    RecyclerView.Adapter<CategoryAdapt.ViewHolder>(){
    class ViewHolder (val myView:View):RecyclerView.ViewHolder(myView){
val layout :ConstraintLayout= myView.findViewById(R.id.myView)
        val txtCategoryName : TextView = myView.findViewById(R.id.lblCategotyName)
        val catThumb:ImageView = myView.findViewById(R.id.imgCatThumb)
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(parent.context).inflate(R.layout.categoryitem,parent,false)
    return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
       return data.categories.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.txtCategoryName.text = data.categories[position].strCategory
        Glide.with(context).load(data.categories[position].strCategoryThumb).into(holder.catThumb)
        holder.layout.setOnClickListener{
            listener.onItemClicked( data.categories[position].strCategory.toString())
        }
    }
}