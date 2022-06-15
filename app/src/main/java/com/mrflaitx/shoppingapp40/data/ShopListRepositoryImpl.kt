package com.mrflaitx.shoppingapp40.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mrflaitx.shoppingapp40.domain.entity.ShopItem
import com.mrflaitx.shoppingapp40.domain.repository.ShopListRepository
import java.lang.RuntimeException
import kotlin.random.Random

class ShopListRepositoryImpl : ShopListRepository {

    private val liveShopList = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({ o1, o2 ->
        o1.id.compareTo(o2.id)
    })

    private var autoIncrementId = 0

    init {
        for (i in 0..100) {
            addShopItem(
                ShopItem(
                    "tomato",
                    i,
                    Random.nextBoolean()
                )
            )
        }
    }

    override fun addShopItem(shopItem: ShopItem) {

        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        removeShopItem(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { item ->
            item.id == shopItemId
        } ?: throw RuntimeException("Element not found $shopItemId")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return liveShopList
    }
    private fun updateList(){
        liveShopList.value = shopList.toList()
    }
}