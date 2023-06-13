package com.ithirteeng.features.bucket.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.ithirteeng.features.bucket.R
import com.ithirteeng.features.bucket.databinding.CounterViewLayoutBinding

class CounterView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : LinearLayout(context, attrs) {

    private val view = LayoutInflater.from(context).inflate(R.layout.counter_view_layout, this)

    private val binding = CounterViewLayoutBinding.bind(view)

    private var value: Int = 1

    fun getValue(): Int {
        return value
    }

    fun onButtonsClick(onValueBelowZero: () -> Unit) {
        onPlusButtonClick()
        onMinusButtonClick(onValueBelowZero)
    }

    private fun onPlusButtonClick() {
        binding.plusButton.setOnClickListener {
            value++
            binding.quantityTextView.text = value.toString()
        }
    }

    private fun onMinusButtonClick(onValueBelowZero: () -> Unit) {
        binding.minusButton.setOnClickListener {
            value--
            if (value == 0) {
                onValueBelowZero()
            }
        }
    }
}