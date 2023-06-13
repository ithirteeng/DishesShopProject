package com.ithirteeng.features.cart.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.ithirteeng.common.design.R.string.pay
import com.ithirteeng.common.helpers.DateHelper
import com.ithirteeng.features.cart.R
import com.ithirteeng.features.cart.databinding.FragmentCartBinding
import com.ithirteeng.features.cart.presentation.CartViewModel
import com.ithirteeng.features.cart.ui.adapter.CartAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : Fragment() {

    companion object {
        fun provideScreen() = FragmentScreen { CartFragment() }
    }

    private lateinit var binding: FragmentCartBinding

    private val viewModel: CartViewModel by viewModel()

    private val cartAdapter by lazy {
        CartAdapter(
            deleteDish = {
                viewModel.deleteDishFromCart(it) {
                    showError()
                }
            },
            onChange = { cartModel, quantity ->
                viewModel.changeDishQuantity(cartModel, quantity)
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val layout = inflater.inflate(R.layout.fragment_cart, container, false)
        binding = FragmentCartBinding.bind(layout)

        setupViews()
        getList()

        observeCompletionLiveData()
        observeItemsListLiveData()
        observeBillLiveData()

        return binding.root
    }

    private fun setupViews() {
        binding.cartRecyclerView.adapter = cartAdapter
        binding.dateTextView.text = DateHelper.getDateInFullFormat()
    }

    private fun getList() {
        viewModel.getModelsList {
            showError()
        }
    }

    private fun observeItemsListLiveData() {
        viewModel.dishesListLiveData.observe(this.viewLifecycleOwner) {
            cartAdapter.submitList(it)
        }
    }

    private fun observeBillLiveData() {
        viewModel.billLiveData.observe(this.viewLifecycleOwner) {
            binding.buyButton.text = getString(pay).replace(Regex("%d"), it.toString())
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

    private fun showError() {
        Toast.makeText(requireContext(), "ERROR", Toast.LENGTH_SHORT).show()
    }
}