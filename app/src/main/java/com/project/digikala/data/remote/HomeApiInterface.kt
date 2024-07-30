package com.project.digikala.data.remote

import com.project.digikala.data.model.ResponseResult
import com.project.digikala.data.model.home.AmazingItem
import com.project.digikala.data.model.home.MainCategory
import com.project.digikala.data.model.home.Slider
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterface {

    @GET("v1/getSlider")
    suspend fun getSlider() : Response<ResponseResult<List<Slider>>>

    @GET("v1/getAmazingProducts")
    suspend fun getAmazingItems() : Response<ResponseResult<List<AmazingItem>>>

    @GET("v1/getSuperMarketAmazingProducts")
    suspend fun getAmazingSuperMarketItems() : Response<ResponseResult<List<AmazingItem>>>

    @GET("v1/get4Banners")
    suspend fun getProposalBanners() : Response<ResponseResult<List<Slider>>>

    @GET("v1/getCategories")
    suspend fun getCategories() : Response<ResponseResult<List<MainCategory>>>

    @GET("v1/getCenterBanners")
    suspend fun getCenterBanners() : Response<ResponseResult<List<Slider>>>



}