package com.mrflaitx.shoppingapp40.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.mrflaitx.shoppingapp40.data.local.ShopItemMapper
import com.mrflaitx.shoppingapp40.data.local.ShopListDao
import com.mrflaitx.shoppingapp40.domain.entity.ShopItem
import com.mrflaitx.shoppingapp40.domain.repository.ShopListRepository
import javax.inject.Inject

class ShopListRepositoryImpl @Inject constructor(private val shopListDao: ShopListDao): ShopListRepository{

    val mapper = ShopItemMapper()
    private val liveShopList = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({ o1, o2 ->
        o1.id.compareTo(o2.id)
    })

    override suspend fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }



    override suspend fun removeShopItem(shopItem: ShopItem) {

       shopListDao.removeShopItem(mapper.mapEntityToDbModel(shopItem))
        updateList()
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        shopListDao.editShopItem(mapper.mapEntityToDbModel(shopItem))
    }



     override fun getShopItem(shopItem: ShopItem) {

     }
    override suspend fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
       shopListDao.getAllShopItems()
    ) {
        mapper.mapListDbModelToListEntity(it)
    }

    private fun updateList() {
        liveShopList.value = shopList.toList()
    }
}