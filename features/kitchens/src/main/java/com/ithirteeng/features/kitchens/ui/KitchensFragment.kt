package com.ithirteeng.features.kitchens.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.ithirteeng.features.kitchens.R
import com.ithirteeng.features.kitchens.databinding.FragmentKitchensBinding
import com.ithirteeng.features.kitchens.presentation.KitchensViewModel
import com.ithirteeng.features.kitchens.ui.adapter.CategoriesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class KitchensFragment : Fragment() {

    companion object {
        fun provideScreen() = FragmentScreen { KitchensFragment() }
    }

    private lateinit var binding: FragmentKitchensBinding

    private val viewModel: KitchensViewModel by viewModel()

    private val categoriesAdapter by lazy {
        CategoriesAdapter {
            //  viewModel.navigateToDishesScreen(it.name)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val layout = inflater.inflate(R.layout.fragment_kitchens, container, false)
        binding = FragmentKitchensBinding.bind(layout)
        setupViews()
        viewModel.getCategories { showError(it) }
        observeCategoriesLiveData()


        return binding.root
    }

    private fun setupViews() {
        binding.progressBar.visibility = View.VISIBLE
        binding.categoriesRecyclerView.adapter = categoriesAdapter
    }

    private fun observeCategoriesLiveData() {
        viewModel.categoriesLiveData.observe(this.viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            categoriesAdapter.submitList(it)
        }
    }

    private fun showError(throwable: Throwable) {
        binding.progressBar.visibility = View.GONE
        Toast.makeText(requireContext(), throwable.message, Toast.LENGTH_SHORT).show()
    }

}