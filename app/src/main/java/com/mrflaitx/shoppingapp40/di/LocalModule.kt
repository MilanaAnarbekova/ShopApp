package com.mrflaitx.shoppingapp40.di

import android.content.Context
import com.mrflaitx.shoppingapp40.data.local.AppDataBase
import com.mrflaitx.shoppingapp40.data.local.RoomClient
import com.mrflaitx.shoppingapp40.data.local.ShopListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent ::class)
class LocalModule {

    @Singleton
    private val roomClient = RoomClient()

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) :AppDataBase{
        return roomClient.provideRoomDatabase(context)
    }

    @Singleton
    @Provides
    fun provideShopListDao(appDataBase: AppDataBase) : ShopListDao{
        return roomClient.provideDatabaseDao(appDataBase)
    }



}

