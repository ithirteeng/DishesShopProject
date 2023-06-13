package com.ithirteeng.features.category.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ithirteeng.common.design.R.*
import com.ithirteeng.features.category.R
import com.ithirteeng.features.category.databinding.DishItemLayoutBinding
import com.ithirteeng.features.category.domain.model.DishesModel

class DishesAdapter(
    private val onItemClick: (DishesModel) -> Unit,
) : ListAdapter<DishesModel, DishesAdapter.DishesViewHolder>(DishesDiffUtilCallBack) {

    inner class DishesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = DishItemLayoutBinding.bind(view)

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(item: DishesModel) {
            onItemClick(item)
            Glide
                .with(binding.root)
                .load(item.imageUrl)
                .placeholder(binding.root.context.getDrawable(drawable.image_placeholder))
                .error(binding.root.context.getDrawable(drawable.image_placeholder))
                .into(binding.dishImageView)
            binding.dishNameTextView.text = item.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.dish_item_layout, parent, false)
        return DishesViewHolder(layout)
    }

    override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

object DishesDiffUtilCallBack : DiffUtil.ItemCallback<DishesModel>() {
    override fun areItemsTheSame(oldItem: DishesModel, newItem: DishesModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DishesModel, newItem: DishesModel): Boolean {
        return oldItem.id == newItem.id
    }

}