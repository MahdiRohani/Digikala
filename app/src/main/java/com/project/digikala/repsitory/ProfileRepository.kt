package com.project.digikala.repsitory


import com.project.digikala.data.model.home.AmazingItem
import com.project.digikala.data.model.home.MainCategory
import com.project.digikala.data.model.home.Slider
import com.project.digikala.data.model.home.StoreProduct
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

    suspend fun getAmazingSuperMarketItems() : NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingSuperMarketItems()
        }

    suspend fun getProposalBanners() : NetworkResult<List<Slider>> =
        safeApiCall {
            api.getProposalBanners()
        }

    suspend fun getCategories() : NetworkResult<List<MainCategory>> =
        safeApiCall {
            api.getCategories()
        }

    suspend fun getCenterBanners() : NetworkResult<List<Slider>> =
        safeApiCall {
            api.getCenterBanners()
        }

    suspend fun getBestsellerItems() : NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getBestsellerItems()
        }

    suspend fun getMostVisitedItems() : NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostVisitedItems()
        }

    suspend fun getMostFavoriteItems() : NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostFavoriteItems()
        }

    suspend fun getMostDiscountedItems() : NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostDiscountedItems()
        }
}