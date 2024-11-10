package com.example.mealapp.fragmentPkg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealapp.R
import com.example.mealapp.adapterPkg.CategoryAdapt
import com.example.mealapp.adapterPkg.MealCategoryAdapt
import com.example.mealapp.modelPkg.Category
import com.example.mealapp.modelPkg.Meal
import com.example.mealapp.servicePkg.CategoryConnection
import com.example.mealapp.servicePkg.MealCategoryConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MealFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MealFragment : Fragment() {
    var categoryName: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryName = arguments?.getString("categoryName").toString()
        val lstMeals: RecyclerView = view.findViewById(R.id.rvMeals)
        lifecycleScope.launch {
            var result = MealCategoryConnection.serviceMealCategory.getMealByCategoryName(
                categoryName
            )
            withContext(Dispatchers.IO) {
                lstMeals.adapter =
                    result.body()?.let { MealCategoryAdapt(it, requireContext()) }
                lstMeals.layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //categoryName = arguments?.getString("categoryName")

        val viewMeal = inflater.inflate(R.layout.fragment_meal, container, false)

//        lifecycleScope.launch {
//            var result : Response<Meal>
//            withContext(Dispatchers.IO) {
//                if (categoryName != null) {
//                    println(categoryName)
//                    result = MealCategoryConnection.serviceMealCategory.getMealByCategoryName(
//                        categoryName!!
//                    )
//                    val lstMeals: RecyclerView = viewMeal.findViewById(R.id.rvMeals)
//                    lstMeals.adapter =
//                        result.body()?.let { MealCategoryAdapt(it, requireContext()) }
//                    lstMeals.layoutManager = LinearLayoutManager(requireContext())
//                }
//           }
//        }
        return viewMeal

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MealFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MealFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}