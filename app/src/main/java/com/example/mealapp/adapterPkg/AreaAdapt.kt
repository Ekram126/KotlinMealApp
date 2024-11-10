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
import com.example.mealapp.modelPkg.Area

class AreaAdapt (val data : Area, val context:Context):
    RecyclerView.Adapter<AreaAdapt.ViewHolder>(){
    class ViewHolder (val myView:View):RecyclerView.ViewHolder(myView){
val layout :ConstraintLayout= myView.findViewById(R.id.myView)
        val txtAreaName : TextView = myView.findViewById(R.id.lblAreaName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(parent.context).inflate(R.layout.areaitem,parent,false)
    return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
       return data.meals.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtAreaName.text = data.meals[position].strArea
//        holder.layout.setOnClickListener({
//            Toast.makeText(context, data.get(position).title, Toast.LENGTH_SHORT).show()
//        })
    }
}