package com.mrflaitx.shoppingapp40.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrflaitx.shoppingapp40.data.ShopListRepositoryImpl
import com.mrflaitx.shoppingapp40.data.local.ShopListDao
import com.mrflaitx.shoppingapp40.domain.entity.ShopItem
import com.mrflaitx.shoppingapp40.domain.usecases.*
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.android.scopes.ViewScoped
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject  constructor(
    private val addShopItemUseCase: AddShopItemUseCase,
    private val getShopListUseCase: GetShopListUseCase,
    private val removeUseCase: RemoveShopItemUseCase,
    private val editShopItemUseCase: EditShopItemUseCase
) : ViewModel(){

     fun addShopItem(shopItem: ShopItem){
        viewModelScope.launch {
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

   suspend fun getShopList() =
            getShopListUseCase.getShopList()



    fun removeShopItem(shopItem: ShopItem){
        viewModelScope.launch {
            removeUseCase.removeShopItem(shopItem)
        }
    }

    fun editShopItem(shopItem: ShopItem){
        viewModelScope.launch {
            val newItem = shopItem.copy(enable = !shopItem.enable)
            editShopItemUseCase.editShopItem(newItem)
        }
    }
//    fun getShopItem(shopItem: ShopItem) : ShopItem{
//        return getShopItemUseCase.getShopItem(shopItem)
//    }

}