package com.example.obss_ecommerce

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.obss_ecommerce.databinding.ItemProductBinding

class ProductAdapter(
    val products: List<Product>,
    val onItemClicked: ((product: Product) -> Unit)? = null,
    private val onFavoriteChecked: ((Product, Boolean) -> Unit)? = null
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.tvProductPrice.text = products[position].name
        holder.binding.tvProductPrice.text = products[position].price.toString()
        holder.binding.ivProduct.setImageResource(products[position].image)
        holder.binding.checkboxItemProduct.isChecked = products[position].isFavourite
        holder.binding.checkboxItemProduct.setOnCheckedChangeListener { _, isChecked ->
            onFavoriteChecked?.let { it(products[position], isChecked) }
        }

        holder.binding.root.setOnClickListener {
            onItemClicked?.let { it1 -> it1(products[position]) }
        }
    }

}