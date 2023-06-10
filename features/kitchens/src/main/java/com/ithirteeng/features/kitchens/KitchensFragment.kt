package com.ithirteeng.features.kitchens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.ithirteeng.features.kitchens.databinding.FragmentKitchensBinding

class KitchensFragment : Fragment() {

    companion object {
        fun provideScreen() = FragmentScreen { KitchensFragment() }
    }

    private lateinit var binding: FragmentKitchensBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val layout = inflater.inflate(R.layout.fragment_kitchens, container, false)
        binding = FragmentKitchensBinding.bind(layout)

        return binding.root
    }

}