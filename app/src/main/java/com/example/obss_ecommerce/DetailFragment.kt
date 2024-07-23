package com.example.obss_ecommerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.obss_ecommerce.databinding.FragmentDetailBinding
import com.example.obss_ecommerce.databinding.FragmentProductsBinding

class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView.text = args.product.name
        binding.imageView.setImageResource(args.product.image)


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}