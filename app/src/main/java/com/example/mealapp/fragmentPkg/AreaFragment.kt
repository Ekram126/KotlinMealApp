package com.example.mealapp.fragmentPkg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.launch

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealapp.R
import com.example.mealapp.adapterPkg.AreaAdapt
import com.example.mealapp.adapterPkg.CategoryAdapt
import com.example.mealapp.modelPkg.Area
import com.example.mealapp.modelPkg.Category
import com.example.mealapp.servicePkg.AreaConnection
import com.example.mealapp.servicePkg.CategoryConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class AreaFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val viewArea = inflater.inflate(R.layout.fragment_area, container, false)

        lifecycleScope.launch {
            var result : Response<Area>
            withContext(Dispatchers.IO) {
                result=   AreaConnection.areaService.getAllArea()

            }
            val lstCategories: RecyclerView = viewArea.findViewById(R.id.rvArea)
            lstCategories.adapter = result.body()?.let { AreaAdapt(it,requireContext()) }
            lstCategories.layoutManager = LinearLayoutManager(requireContext())


        }



        return  viewArea

    }


}