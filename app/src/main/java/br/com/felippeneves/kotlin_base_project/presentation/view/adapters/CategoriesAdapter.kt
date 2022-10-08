package br.com.felippeneves.kotlin_base_project.presentation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.felippeneves.kotlin_base_project.databinding.ItemCategoryBinding
import br.com.felippeneves.kotlin_base_project.domain.model.CategoryEnt
import br.com.felippeneves.kotlin_base_project.presentation.model.CategoryUiModel
import com.squareup.picasso.Picasso

class CategoriesAdapter(
    private val categories: List<CategoryEnt>
) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val itemView =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categories[position]

        with(holder) {
            binding.tvMeal.text = category.name
            Picasso.get().load(category.thumb).into(binding.ivMeal)
        }
    }

    override fun getItemCount() = categories.size

    inner class CategoriesViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)
}