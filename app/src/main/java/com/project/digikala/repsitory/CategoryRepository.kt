package com.project.digikala.repsitory


import com.project.digikala.data.model.category.SubCategory
import com.project.digikala.data.model.home.AmazingItem
import com.project.digikala.data.model.home.MainCategory
import com.project.digikala.data.model.home.Slider
import com.project.digikala.data.model.home.StoreProduct
import com.project.digikala.data.remote.BaseApiResponse
import com.project.digikala.data.remote.CategoryApiInterface
import com.project.digikala.data.remote.HomeApiInterface
import com.project.digikala.data.remote.NetworkResult
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api : CategoryApiInterface) : BaseApiResponse() {

    suspend fun getSubCategories() : NetworkResult<SubCategory> =
        safeApiCall {
            api.getSubCategories()
        }


}