package com.example.shopitemtest.data

import com.example.shopitemtest.domain.ShopItem
import com.example.shopitemtest.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrement = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrement++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        deleteShopItem(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemID: Int): ShopItem {
        return shopList.find {
            it.id == shopItemID
        } ?: throw RuntimeException("Элемент айди $shopItemID не был найден")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}