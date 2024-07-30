package com.project.digikala.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.digikala.data.model.home.AmazingItem
import com.project.digikala.data.model.home.MainCategory
import com.project.digikala.data.model.home.Slider
import com.project.digikala.data.model.home.StoreProduct
import com.project.digikala.data.remote.NetworkResult
import com.project.digikala.repsitory.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val amazingItems = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val superMarketItems = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val banners = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val categories = MutableStateFlow<NetworkResult<List<MainCategory>>>(NetworkResult.Loading())
    val centerBannerItems = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val bestSellerItems = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())
    val mostVisitedItems = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())
    val mostFavoriteItems = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())

    suspend fun getAllDataFromServer() {
        viewModelScope.launch {

            launch { slider.emit(repository.getSlider()) }
            launch { amazingItems.emit(repository.getAmazingItems()) }
            launch { superMarketItems.emit(repository.getAmazingSuperMarketItems()) }
            launch { banners.emit(repository.getProposalBanners()) }
            launch { categories.emit(repository.getCategories()) }
            launch { centerBannerItems.emit(repository.getCenterBanners()) }
            launch { bestSellerItems.emit(repository.getBestsellerItems()) }
            launch { mostVisitedItems.emit(repository.getMostVisitedItems()) }
            launch { mostFavoriteItems.emit(repository.getMostFavoriteItems()) }



        }
    }

}