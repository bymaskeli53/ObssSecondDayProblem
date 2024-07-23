package com.example.obss_ecommerce

import android.os.Parcelable


@kotlinx.parcelize.Parcelize
data class Product(val name: String,  val image: Int,val price: Double,var isFavourite: Boolean = false) : Parcelable
