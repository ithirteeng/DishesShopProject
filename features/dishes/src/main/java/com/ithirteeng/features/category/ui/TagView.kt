package com.ithirteeng.features.category.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.ithirteeng.common.design.R.color.black
import com.ithirteeng.common.design.R.color.blue
import com.ithirteeng.common.design.R.color.card_color
import com.ithirteeng.common.design.R.color.main_white
import com.ithirteeng.features.category.R
import com.ithirteeng.features.category.databinding.TagItemLayoutBinding

class TagView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : RelativeLayout(context, attrs) {

    private val tagView =
        LayoutInflater.from(context).inflate(R.layout.tag_item_layout, this)

    private val binding = TagItemLayoutBinding.bind(tagView)

    private var isChosen: Boolean = false

    fun onClick(onClick: () -> Unit) {
        binding.tagCardView.setOnClickListener {
            onClick()
            isChosen = !isChosen
            changeAppearance()
        }
    }

    fun setState(state: Boolean) {
        isChosen = state
        changeAppearance()
    }

    fun getState(): Boolean = isChosen

    private fun changeAppearance() {
        if (isChosen) {
            binding.tagCardView.setCardBackgroundColor(
                context.resources.getColor(blue, context.theme)
            )
            binding.tagNameTextView.setTextColor(
                context.resources.getColor(main_white, context.theme)
            )
        } else {
            binding.tagCardView.setCardBackgroundColor(
                context.resources.getColor(card_color, context.theme)
            )
            binding.tagNameTextView.setTextColor(
                context.resources.getColor(black, context.theme)
            )
        }
    }
}