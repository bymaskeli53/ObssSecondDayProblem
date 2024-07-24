package com.example.obss_ecommerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.obss_ecommerce.databinding.FragmentProductsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProductsFragment : Fragment() {


    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    private val favouriteList = mutableListOf<Product>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val products = createProducts()

        val itemDivider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)


        val adapter = createProductAdapter(products)

        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.favouritesFragment -> {
                    val action =
                        ProductsFragmentDirections.actionProductsFragmentToFavouritesFragment(
                            favouriteList.toTypedArray()
                        )
                    findNavController().navigate(action)
                    true
                }

                else -> false

            }

        }



        binding.rvProducts.adapter = adapter
        binding.rvProducts.addItemDecoration(itemDivider)
    }

    private fun createProductAdapter(products: List<Product>): ProductAdapter {
        val adapter = ProductAdapter(products, { product ->
            val action = ProductsFragmentDirections.actionProductsFragmentToDetailFragment(product)
            findNavController().navigate(action)

        }, { product, isChecked ->
            product.isFavourite = isChecked
            Toast.makeText(
                requireContext(),
                "${product.name} ${if (isChecked) "added" else "removed"} to favourites",
                Toast.LENGTH_SHORT
            ).show()
            if (isChecked) {
                favouriteList.add(product)
            } else {
                favouriteList.remove(product)
            }

        }
        )
        return adapter
    }

    private fun createProducts(): List<Product> {
        val product1 = Product("Product 1", R.drawable.tisort, 19.99)
        val product2 = Product("Product 2", R.drawable.tisort, 25.99)
        val product3 = Product("Product 3", R.drawable.tisort, 30.99)
        val product4 = Product("Product 4", R.drawable.tisort, 45.99)
        val products = listOf(product1, product2, product3, product4)
        return products
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}