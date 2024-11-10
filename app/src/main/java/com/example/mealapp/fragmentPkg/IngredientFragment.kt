package com.example.mealapp.fragmentPkg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealapp.R
import com.example.mealapp.adapterPkg.CategoryAdapt
import com.example.mealapp.adapterPkg.IngredientAdapt
import com.example.mealapp.modelPkg.Category
import com.example.mealapp.modelPkg.Ingredient
import com.example.mealapp.servicePkg.CategoryConnection
import com.example.mealapp.servicePkg.IngredientConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class IngredientFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val viewIngredient = inflater.inflate(R.layout.fragment_ingredient, container, false)

        lifecycleScope.launch {
            var result : Response<Ingredient>
            withContext(Dispatchers.IO) {
                result=   IngredientConnection.serviceIngredients.getAllIngredients()

            }
            val lstIngredients: RecyclerView = viewIngredient.findViewById(R.id.rvIngredient)
            lstIngredients.adapter = result.body()?.let { IngredientAdapt(it,requireContext()) }
            lstIngredients.layoutManager = LinearLayoutManager(requireContext())
        }
        return  viewIngredient
    }

}