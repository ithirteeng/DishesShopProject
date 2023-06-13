package com.ithirteeng.features.category.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ithirteeng.features.category.R
import com.ithirteeng.features.category.databinding.TagItemLayoutBinding

class TagsAdapter(
    onTagClick: (String) -> Unit,
) : ListAdapter<String, TagsAdapter.TagsViewHolder>(StringDiffUtilCallBack) {

    inner class TagsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = TagItemLayoutBinding.bind(view)

        fun bind(tag: String) {
            binding.tagNameTextView.text = tag
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.tag_item_layout, parent, false)
        return TagsViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}

object StringDiffUtilCallBack : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}