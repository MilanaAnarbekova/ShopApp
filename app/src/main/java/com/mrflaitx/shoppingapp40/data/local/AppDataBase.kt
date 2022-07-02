package com.mrflaitx.shoppingapp40.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mrflaitx.shoppingapp40.data.Dto.ShopItemDto

@Database(entities = [ShopItemDto::class], version = 1, exportSchema = false )
abstract class AppDataBase : RoomDatabase() {

    abstract fun shopListDao():ShopListDao
}