package com.ithirteeng.features.cart.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.ithirteeng.features.cart.R
import com.ithirteeng.features.cart.databinding.CounterViewLayoutBinding

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

    fun setValue(value: Int) {
        this.value = value
        binding.quantityTextView.text = value.toString()
    }


    fun onPlusButtonClick(onValueChange: (Int) -> Unit) {
        binding.plusButton.setOnClickListener {
            value++
            onValueChange(value)
            binding.quantityTextView.text = value.toString()
        }
    }

    fun onMinusButtonClick(onValueBelowZero: () -> Unit) {
        binding.minusButton.setOnClickListener {
            value--
            binding.quantityTextView.text = value.toString()
            if (value == 0) {
                onValueBelowZero()
            }
        }
    }
}