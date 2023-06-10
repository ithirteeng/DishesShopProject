package com.ithirteeng.features.kitchens.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ithirteeng.common.design.R.drawable.image_placeholder
import com.ithirteeng.features.kitchens.R
import com.ithirteeng.features.kitchens.databinding.CategoryItemLayoutBinding
import com.ithirteeng.features.kitchens.domain.model.CategoryModel

class CategoriesAdapter(
    private val onCategoryClick: (CategoryModel) -> Unit,
) : ListAdapter<CategoryModel, CategoriesAdapter.CategoryViewHolder>(CategoryDiffCallBack) {

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = CategoryItemLayoutBinding.bind(view)

        private lateinit var categoryModel: CategoryModel

        init {
            binding.categoryButton.setOnClickListener { onCategoryClick(categoryModel) }
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(categoryModel: CategoryModel) {
            this.categoryModel = categoryModel
            binding.categoryTextView.text = categoryModel.name

            Glide
                .with(binding.root)
                .load(categoryModel.imageUrl)
                .placeholder(binding.root.context.getDrawable(image_placeholder))
                .error(binding.root.context.getDrawable(image_placeholder))
                .into(binding.categoryButton)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.category_item_layout, parent, false)
        return CategoryViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

object CategoryDiffCallBack : DiffUtil.ItemCallback<CategoryModel>() {
    override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
        return oldItem == newItem
    }

}