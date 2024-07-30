package com.project.digikala.data.model.home

data class StoreProduct(
    val _id: String,
    val discountPercent: Int,
    val image: String,
    val name: String,
    val price: Long,
    val seller: String
)