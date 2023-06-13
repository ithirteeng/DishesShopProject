package com.ithirteeng.features.cart.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ithirteeng.common.cart.domain.model.CartModel
import com.ithirteeng.common.design.R
import com.ithirteeng.features.cart.R.layout.cart_item_layout
import com.ithirteeng.features.cart.databinding.CartItemLayoutBinding

class CartAdapter(
    private val deleteDish: (CartModel) -> Unit,
    private val onChange: (CartModel, Int) -> Unit,
) : ListAdapter<CartModel, CartAdapter.CartViewHolder>(CartModelDiffUtilCallBack) {

    inner class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = CartItemLayoutBinding.bind(view)

        private lateinit var cartModel: CartModel

        init {
            binding.counterView.onMinusButtonClick(
                onValueBelowZero = {
                    deleteDish(cartModel)
                },
                onValueChange = {
                    onChange(cartModel, it)
                    cartModel.quantity = it + 1
                }
            )
            binding.counterView.onPlusButtonClick {
                onChange(cartModel, it)
                cartModel.quantity = it - 1
            }
        }

        @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
        fun bind(cartModel: CartModel) {
            this.cartModel = cartModel
            binding.dishPriceTextView.text = "${cartModel.price}₽"
            binding.dishWeightTextView.text = cartModel.weight.toString() +
                    binding.root.context.getString(R.string.gram_short)
            binding.textView.text = cartModel.name
            binding.counterView.setValue(cartModel.quantity)
            Glide
                .with(binding.root)
                .load(cartModel.imageUrl)
                .placeholder(binding.root.context.getDrawable(R.drawable.image_placeholder))
                .error(binding.root.context.getDrawable(R.drawable.image_placeholder))
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(cart_item_layout, parent, false)
        return CartViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

object CartModelDiffUtilCallBack : DiffUtil.ItemCallback<CartModel>() {
    override fun areItemsTheSame(oldItem: CartModel, newItem: CartModel): Boolean {
        return oldItem.dishId == newItem.dishId
    }

    override fun areContentsTheSame(oldItem: CartModel, newItem: CartModel): Boolean {
        return oldItem == newItem
    }

}