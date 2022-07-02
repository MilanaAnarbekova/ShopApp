package com.mrflaitx.shoppingapp40.data.local

import android.content.Context
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext

class RoomClient {
    fun provideRoomDatabase(context: Context) =
        Room.databaseBuilder(context, AppDataBase::class.java, "database").allowMainThreadQueries()
            .fallbackToDestructiveMigration().build()

    fun provideDatabaseDao(appDataBase: AppDataBase):ShopListDao{
        return appDataBase.shopListDao()
    }
}
