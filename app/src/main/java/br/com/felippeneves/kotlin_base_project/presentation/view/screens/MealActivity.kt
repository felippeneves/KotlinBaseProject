package br.com.felippeneves.kotlin_base_project.presentation.view.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.felippeneves.kotlin_base_project.databinding.ActivityMealBinding
import br.com.felippeneves.kotlin_base_project.domain.model.CategoryEnt
import br.com.felippeneves.kotlin_base_project.presentation.view.adapters.CategoriesAdapter
import br.com.felippeneves.kotlin_base_project.presentation.viewmodel.MealViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealActivity : AppCompatActivity() {

    private val viewModel: MealViewModel by viewModel()

    private lateinit var binding: ActivityMealBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loadingScreen()
    }

    private fun loadingScreen() {

        viewModel.categories.observe(this@MealActivity) { listCategory ->
            populateMealsCategory(listCategory)
        }

        viewModel.getCategories()

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this@MealActivity, UsersActivity::class.java))
        }
    }

    private fun populateMealsCategory(categories: List<CategoryEnt>) {
        binding.rvMeals.adapter = CategoriesAdapter(categories)
    }
}