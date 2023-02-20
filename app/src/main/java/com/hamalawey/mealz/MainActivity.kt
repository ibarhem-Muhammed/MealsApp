package com.hamalawey.mealz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.hamalawey.mealz.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MealsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mealsAdapter= MealsAdapter()
        viewModel.getMeals()
        lifecycleScope.launch {
            viewModel.categories.collect {
                mealsAdapter.submitList(it?.categories)
                binding.categoryRv.adapter = mealsAdapter
            }
        }

//        initObserver()
    }

//    private fun initObserver() {
//
//
//    }
}