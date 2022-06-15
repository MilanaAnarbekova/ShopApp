package com.mrflaitx.shoppingapp40.presentation

import androidx.lifecycle.ViewModel
import com.mrflaitx.shoppingapp40.data.ShopListRepositoryImpl
import com.mrflaitx.shoppingapp40.domain.entity.ShopItem
import com.mrflaitx.shoppingapp40.domain.usecases.AddShopItemUseCase
import com.mrflaitx.shoppingapp40.domain.usecases.EditShopItemUseCase
import com.mrflaitx.shoppingapp40.domain.usecases.GetShopListUseCase
import com.mrflaitx.shoppingapp40.domain.usecases.RemoveShopItemUseCase

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl()

    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    fun addShopItem(shopItem: ShopItem){
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun getShopList() = getShopListUseCase.getShopList()

    fun removeShopItem(shopItem: ShopItem){
        removeUseCase.removeShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem){
        val newItem = shopItem.copy(enable = !shopItem.enable)
        editShopItemUseCase.editShopItem(newItem)
    }

}