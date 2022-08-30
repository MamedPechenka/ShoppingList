package com.example.shopitemtest.domain

import androidx.lifecycle.LiveData

class GetShopListInteractor(private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}