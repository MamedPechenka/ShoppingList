package com.example.shopitemtest.domain

class GetShopItemInteractor(private val shopListRepository: ShopListRepository) {

    fun getShopItem(shopItemID: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemID)
    }
}