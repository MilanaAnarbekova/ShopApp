package com.mrflaitx.shoppingapp40.domain.usecases

import com.mrflaitx.shoppingapp40.domain.entity.ShopItem
import com.mrflaitx.shoppingapp40.domain.repository.ShopListRepository
import javax.inject.Inject

class RemoveShopItemUseCase @Inject constructor(private val repository: ShopListRepository) {
    suspend fun removeShopItem(shopItem: ShopItem){
        repository.removeShopItem(shopItem)
    }
}