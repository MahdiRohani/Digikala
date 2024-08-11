package com.project.digikala.data.db
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.digikala.data.model.basket.CartItem
import com.project.digikala.data.model.basket.CartStatus
import kotlinx.coroutines.flow.Flow


@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCartItem(cart : CartItem)

    @Query("select * from shopping_cart where cartStatus=:status")
    fun getAllItems(status: CartStatus) : Flow<List<CartItem>>

    @Delete
    suspend fun removeFromCart(item: CartItem)

    @Query("update shopping_cart set count=:newCount where itemId=:id")
    suspend fun changeCountCartItem(newCount : Int , id : String)

    @Query("update shopping_cart set cartStatus=:newStatus where itemId=:id")
    suspend fun changeStatusCartItem(newStatus : CartStatus , id : String)

    @Query("select total(count) as count from shopping_cart where cartStatus=:status")
    fun getCartItemsCart(status: CartStatus) : Flow<Int>




}