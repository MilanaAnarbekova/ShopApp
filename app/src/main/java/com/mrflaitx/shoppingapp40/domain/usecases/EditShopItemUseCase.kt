package com.mrflaitx.shoppingapp40.domain.usecases

import com.mrflaitx.shoppingapp40.domain.entity.ShopItem
import com.mrflaitx.shoppingapp40.domain.repository.ShopListRepository
import javax.inject.Inject

class EditShopItemUseCase @Inject constructor(private val repository: ShopListRepository) {
    suspend fun editShopItem(shopItem: ShopItem){
        repository.editShopItem(shopItem)
    }
}