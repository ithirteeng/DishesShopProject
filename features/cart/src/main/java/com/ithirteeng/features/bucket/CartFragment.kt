package com.ithirteeng.features.bucket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.ithirteeng.features.bucket.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    companion object {
        fun provideScreen() = FragmentScreen { CartFragment() }
    }

    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val layout = inflater.inflate(R.layout.fragment_cart, container, false)
        binding = FragmentCartBinding.bind(layout)

        return binding.root
    }
}