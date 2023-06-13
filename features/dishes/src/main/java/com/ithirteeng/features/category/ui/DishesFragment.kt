package com.ithirteeng.features.category.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.ithirteeng.common.extensions.addBackPressedListener
import com.ithirteeng.features.category.R
import com.ithirteeng.features.category.databinding.FragmentDishesBinding
import com.ithirteeng.features.category.di.FRAGMENT_VIEW_MODEL
import com.ithirteeng.features.category.presentation.DishesViewModel
import com.ithirteeng.features.category.ui.adapter.DishesAdapter
import com.ithirteeng.features.category.ui.adapter.TagsAdapter
import com.ithirteeng.features.category.ui.dialog.DishDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class DishesFragment : Fragment() {

    companion object {
        private const val CATEGORY_NAME = "CATEGORY_NAME"

        fun provideScreen(categoryName: String) = FragmentScreen {
            DishesFragment().apply {
                val bundle = Bundle()
                bundle.putString(CATEGORY_NAME, categoryName)
                arguments = bundle
            }
        }
    }

    private lateinit var binding: FragmentDishesBinding

    private val viewModel: DishesViewModel by viewModel(named(FRAGMENT_VIEW_MODEL))

    private val tagsAdapter by lazy {
        TagsAdapter {
            onTagClick()
        }
    }

    private val dishesAdapter by lazy {
        DishesAdapter {
            showDialogFragment(DishDialogFragment(it))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val layout = inflater.inflate(R.layout.fragment_dishes, container, false)
        binding = FragmentDishesBinding.bind(layout)

        setupViews()
        getCategoryName()

        getDishesAndTagsList()
        setupObservers()

        setupOnButtonClickFunctions()

        return binding.root
    }

    private fun setupViews() {
        binding.tagsRecyclerView.adapter = tagsAdapter
        binding.dishesRecyclerView.adapter = dishesAdapter
    }

    private fun getDishesAndTagsList() {
        viewModel.getDishesList {
            showError()
        }
    }

    private fun onTagClick() {
        val list = tagsAdapter.getFilters()
        dishesAdapter.submitList(viewModel.filterList(list))
    }

    private fun setupObservers() {
        observeDishesLiveData()
        observeTagsLiveData()
        observeCompletionLiveData()
    }

    private fun observeDishesLiveData() {
        viewModel.dishesListLiveData.observe(this.viewLifecycleOwner) {
            dishesAdapter.submitList(it)
        }
    }

    private fun observeTagsLiveData() {
        viewModel.tagsLiveData.observe(this.viewLifecycleOwner) {
            tagsAdapter.submitList(it)
        }
    }

    private fun observeCompletionLiveData() {
        viewModel.completionLiveData.observe(this.viewLifecycleOwner) { isCompleted ->
            if (isCompleted) {
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.VISIBLE
            }
        }
    }

    private fun getCategoryName() {
        val category = arguments?.getString(CATEGORY_NAME)
        binding.kitchenNameTextView.text = category
    }

    private fun setupOnButtonClickFunctions() {
        onBackButtonClick()
        onBackPress()
    }

    private fun onBackButtonClick() {
        binding.backButton.setOnClickListener {
            viewModel.exit()
        }
    }

    private fun onBackPress() {
        this.addBackPressedListener {
            viewModel.exit()
        }
    }

    private fun showError() {
        Toast.makeText(requireContext(), "ERROR", Toast.LENGTH_SHORT).show()
    }

    private fun showDialogFragment(dishDialogFragment: DishDialogFragment) {
        setupDialogFragment(dishDialogFragment)
        dishDialogFragment.show(childFragmentManager, "pick image dialog")
    }

    private fun setupDialogFragment(dishDialogFragment: DishDialogFragment) {
        dishDialogFragment.dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dishDialogFragment.dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dishDialogFragment.setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme)
    }

}