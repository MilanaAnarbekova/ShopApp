package com.mrflaitx.shoppingapp40.domain.repository

import androidx.lifecycle.LiveData
import com.mrflaitx.shoppingapp40.domain.entity.ShopItem

interface ShopListRepository {

    suspend fun addShopItem(shopItem: ShopItem)

    suspend fun removeShopItem(shopItem: ShopItem)

    suspend fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItem: ShopItem)

    // refactor
    suspend fun getShopList(): LiveData<List<ShopItem>>


}