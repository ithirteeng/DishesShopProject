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
import org.koin.androidx.viewmodel.ext.android.viewModel

class KitchensFragment : Fragment() {

    companion object {
        fun provideScreen() = FragmentScreen { KitchensFragment() }
    }

    private lateinit var binding: FragmentKitchensBinding

    private val viewModel: KitchensViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val layout = inflater.inflate(R.layout.fragment_kitchens, container, false)
        binding = FragmentKitchensBinding.bind(layout)

        viewModel.getCategories {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }

        viewModel.categoriesLiveData.observe(this.viewLifecycleOwner) {
            Toast.makeText(requireContext(), "OKK", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}