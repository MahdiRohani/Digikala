package com.project.digikala.data.remote

import com.project.digikala.data.model.ResponseResult
import com.project.digikala.data.model.category.SubCategory
import com.project.digikala.data.model.home.AmazingItem
import com.project.digikala.data.model.home.MainCategory
import com.project.digikala.data.model.home.Slider
import com.project.digikala.data.model.home.StoreProduct
import retrofit2.Response
import retrofit2.http.GET

interface BasketApiInterface {




    @GET("v1/getAllProducts")
    suspend fun getSuggestedItems() : Response<ResponseResult<List<StoreProduct>>>












}