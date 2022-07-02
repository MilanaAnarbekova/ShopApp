package com.mrflaitx.shoppingapp40.domain.usecases

import com.mrflaitx.shoppingapp40.domain.entity.ShopItem
import com.mrflaitx.shoppingapp40.domain.repository.ShopListRepository
import javax.inject.Inject

class AddShopItemUseCase @Inject constructor(private val repository: ShopListRepository) {
    suspend fun addShopItem(shopItem: ShopItem){
        repository.addShopItem(shopItem)
    }
}