package com.example.mealapp.fragmentPkg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import kotlinx.coroutines.launch

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealapp.R
import com.example.mealapp.adapterPkg.CategoryAdapt
import com.example.mealapp.adapterPkg.CategoryListener
import com.example.mealapp.modelPkg.Category
import com.example.mealapp.servicePkg.CategoryConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class CateegoryFragment : Fragment() , CategoryListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val viewCategory = inflater.inflate(R.layout.fragment_cateegory, container, false)

//        lifecycleScope.launch {
//            var result : Response<Category>
//            withContext(Dispatchers.IO) {
//                result=   CategoryConnection.serviceCategories.getAllCategories()
//
//            }
//            val lstCategories: RecyclerView = viewCategory.findViewById(R.id.rvCategories)
//            lstCategories.adapter = result.body()?.let { CategoryAdapt(it,requireContext(),this@CateegoryFragment) }
//            lstCategories.layoutManager = LinearLayoutManager(requireContext())
//        }



        return  viewCategory

    }

    override fun onItemClicked(categoryName: String) {
        val mealFragment = MealFragment()
        val bundle = Bundle()
        bundle.putString("categoryName", categoryName)
        mealFragment.arguments = bundle
        findNavController().navigate(R.id.action_cateegoryFragment_to_mealFragment,bundle)
    }
}