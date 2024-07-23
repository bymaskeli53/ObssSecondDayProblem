package com.example.obss_ecommerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.obss_ecommerce.databinding.FragmentFavouritesBinding


class FavouritesFragment : Fragment() {


    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!

    private val args: FavouritesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavouritesBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val favourites = args.favourites
        val favouriteList = favourites.toMutableList()
        val adapter = ProductAdapter(favouriteList)

        binding.rvFavourites.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}