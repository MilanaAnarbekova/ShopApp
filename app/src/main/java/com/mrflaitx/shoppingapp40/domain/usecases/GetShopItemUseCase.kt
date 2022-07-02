package com.mrflaitx.shoppingapp40.domain.usecases

import com.mrflaitx.shoppingapp40.domain.entity.ShopItem
import com.mrflaitx.shoppingapp40.domain.repository.ShopListRepository
import javax.inject.Inject

class GetShopItemUseCase @Inject constructor(private val repository: ShopListRepository) {
    fun getShopItem(shopItem: ShopItem){
        return repository.getShopItem(shopItem)
    }
}