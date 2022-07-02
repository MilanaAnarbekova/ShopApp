package com.mrflaitx.shoppingapp40.data.Dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_shop_items")
data class ShopItemDto(
    @PrimaryKey(autoGenerate = true )
    var id: Int,
    val name: String,
    val count: Int,
    val enable: Boolean
)
