package com.ithirteeng.features.category.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ithirteeng.features.category.databinding.TagItemLayoutBinding
import com.ithirteeng.features.category.domain.model.TagModel
import com.ithirteeng.features.category.ui.TagView

class TagsAdapter(
    private val onTagClick: (TagModel) -> Unit,
) : ListAdapter<TagModel, TagsAdapter.TagsViewHolder>(TagModelDiffUtilCallBack) {

    inner class TagsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val binding = TagItemLayoutBinding.bind(view)

        fun bind(tag: TagModel) {
            (view as TagView).onClick {
                tag.isChosen = !tag.isChosen
                onTagClick(tag)
            }
            view.setState(false)
            tag.isChosen = view.getState()
            binding.tagNameTextView.text = tag.tag
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsViewHolder {
        val layout = TagView(parent.context)
        return TagsViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun getFilters(): List<String> {
        val resultList = arrayListOf<String>()
        for (filter in currentList) {
            if (filter.isChosen) {
                resultList.add(filter.tag)
            }
        }
        return resultList
    }

}

object TagModelDiffUtilCallBack : DiffUtil.ItemCallback<TagModel>() {
    override fun areItemsTheSame(oldItem: TagModel, newItem: TagModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TagModel, newItem: TagModel): Boolean {
        return oldItem == newItem
    }

}