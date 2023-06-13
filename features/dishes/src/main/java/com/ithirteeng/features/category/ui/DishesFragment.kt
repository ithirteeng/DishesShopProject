package com.ithirteeng.features.category.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.ithirteeng.features.category.R
import com.ithirteeng.features.category.databinding.FragmentDishesBinding

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val layout = inflater.inflate(R.layout.fragment_dishes, container, false)
        binding = FragmentDishesBinding.bind(layout)

        return binding.root
    }

}