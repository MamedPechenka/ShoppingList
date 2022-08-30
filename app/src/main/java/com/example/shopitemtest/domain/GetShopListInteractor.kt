package com.example.shopitemtest.domain

class GetShopListInteractor(private val shopListRepository: ShopListRepository) {

    fun getShopList(): List<ShopItem> {
        return shopListRepository.getShopList()
    }
}