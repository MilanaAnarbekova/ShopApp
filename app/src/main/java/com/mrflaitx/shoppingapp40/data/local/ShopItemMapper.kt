package com.mrflaitx.shoppingapp40.data.local

import com.mrflaitx.shoppingapp40.data.Dto.ShopItemDto
import com.mrflaitx.shoppingapp40.domain.entity.ShopItem

class ShopItemMapper {

    fun mapEntityToDbModel(shopItem: ShopItem): ShopItemDto {
        return ShopItemDto(
            id = shopItem.id,
            name = shopItem.name,
            count = shopItem.count,
            enable = shopItem.enable
        )
    }

    fun mapDbModelToEntity(shopItemDto: ShopItemDto): ShopItem {
        return ShopItem(
            id = shopItemDto.id,
            name = shopItemDto.name,
            count = shopItemDto.count,
            enable = shopItemDto.enable
        )
    }

    fun mapListDbModelToListEntity(list: List<ShopItemDto>) = list.map { dto ->
        mapDbModelToEntity(dto)
    }
}