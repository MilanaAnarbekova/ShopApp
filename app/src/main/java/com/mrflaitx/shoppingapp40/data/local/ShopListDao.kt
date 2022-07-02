package com.mrflaitx.shoppingapp40.data.local

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.*
import com.mrflaitx.shoppingapp40.data.Dto.ShopItemDto
import com.mrflaitx.shoppingapp40.domain.entity.ShopItem

@Dao
interface ShopListDao {

    @Query("SELECT * FROM table_shop_items")
    fun getAllShopItems(): LiveData<List<ShopItemDto>>

    @Insert
    suspend fun addShopItem(ShopItemDto: ShopItemDto)

    @Delete
    suspend fun removeShopItem(ShopItemDto: ShopItemDto)

    @Update
    suspend fun editShopItem(ShopItemDto: ShopItemDto)

//    @Query("SELECT * FROM table_shop_items where id")
//    fun getShopItem(shopItemDto: ShopItemDto) : ShopItemDto

}
