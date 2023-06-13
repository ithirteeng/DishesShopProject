package com.ithirteeng.features.category.ui.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.ithirteeng.common.design.R.*
import com.ithirteeng.features.category.R
import com.ithirteeng.features.category.databinding.DishInfoDialogFragmentLayoutBinding
import com.ithirteeng.features.category.di.DIALOG_VIEW_MODEL
import com.ithirteeng.features.category.domain.model.DishesModel
import com.ithirteeng.features.category.presentation.DishDialogViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class DishDialogFragment(
    private val dishesModel: DishesModel,
) : DialogFragment() {

    private lateinit var binding: DishInfoDialogFragmentLayoutBinding

    private val viewModel: DishDialogViewModel by viewModel(named(DIALOG_VIEW_MODEL))

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = requireActivity().layoutInflater.inflate(
            R.layout.dish_info_dialog_fragment_layout, null
        )
        binding = DishInfoDialogFragmentLayoutBinding.bind(view)

        onCloseButtonClick()

        setupViews()
        onAddToCartButtonClick()

        val builder = AlertDialog.Builder(
            requireActivity(),
            style.MyDialogTheme
        )
        return builder.setView(view).create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeCompletionLiveData()
    }

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    private fun setupViews() {
        binding.dishNameTextView.text = dishesModel.name
        binding.dishDescriptionTextView.text = dishesModel.description
        binding.dishPriceTextView.text = "${dishesModel.price}₽"
        binding.dishWeightTextView.text = dishesModel.weight.toString() +
                binding.root.context.getString(string.gram_short)
        Glide
            .with(binding.root)
            .load(dishesModel.imageUrl)
            .placeholder(binding.root.context.getDrawable(drawable.image_placeholder))
            .error(binding.root.context.getDrawable(drawable.image_placeholder))
            .into(binding.dishImageView)
    }

    private fun onCloseButtonClick() {
        binding.closeDialogButton.setOnClickListener {
            this.dismiss()
        }
    }

    private fun observeCompletionLiveData() {
        viewModel.completionLiveData.observe(this.viewLifecycleOwner) {
            if (it) {
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.VISIBLE
            }
        }
    }

    private fun onAddToCartButtonClick() {
        binding.addToCartButton.setOnClickListener {
            viewModel.addDishToCart(dishesModel) {
                Toast.makeText(requireContext(), "ERROR", Toast.LENGTH_SHORT).show()
            }
            this.dismiss()
        }
    }
}