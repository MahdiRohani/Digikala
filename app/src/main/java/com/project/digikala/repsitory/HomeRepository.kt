package com.project.digikala.repsitory


import com.project.digikala.data.model.home.AmazingItem
import com.project.digikala.data.model.home.Slider
import com.project.digikala.data.remote.BaseApiResponse
import com.project.digikala.data.remote.HomeApiInterface
import com.project.digikala.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api : HomeApiInterface) : BaseApiResponse() {

    suspend fun getSlider() : NetworkResult<List<Slider>> =
        safeApiCall {
            api.getSlider()
        }

    suspend fun getAmazingItems() : NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingItems()
        }
}