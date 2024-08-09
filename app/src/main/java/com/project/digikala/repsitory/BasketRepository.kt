package com.project.digikala.repsitory


import com.project.digikala.data.db.CartDao
import com.project.digikala.data.model.basket.CartItem
import com.project.digikala.data.model.basket.CartStatus
import com.project.digikala.data.model.home.StoreProduct
import com.project.digikala.data.remote.BaseApiResponse
import com.project.digikala.data.remote.BasketApiInterface
import com.project.digikala.data.remote.NetworkResult
import javax.inject.Inject

class BasketRepository @Inject constructor(
    private val api: BasketApiInterface,
    private val dao: CartDao
) : BaseApiResponse() {

    val currentCartStatus = dao.getAllItems(CartStatus.CURRENT_CARD)
    val nextCartItems = dao.getAllItems(CartStatus.NEXT_CART)


    suspend fun getSuggestedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestedItems()
        }

    suspend fun insertCartItem(cart: CartItem) {
        dao.insertCartItem(cart)
    }

    suspend fun removeFromCart(item: CartItem){
        dao.removeFromCart(item)
    }

    suspend fun changeCartItemCount(newCount : Int , id : String){
        dao.changeCountCartItem(newCount , id)
    }

    suspend fun changeCartItemStatus(newStatus: CartStatus , id : String){
        dao.changeStatusCartItem(newStatus , id)
    }




}