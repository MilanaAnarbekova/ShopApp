package com.mrflaitx.shoppingapp40.di

import com.mrflaitx.shoppingapp40.data.ShopListRepositoryImpl
import com.mrflaitx.shoppingapp40.domain.repository.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsRepository(shopListRepositoryImpl: ShopListRepositoryImpl): ShopListRepository
}