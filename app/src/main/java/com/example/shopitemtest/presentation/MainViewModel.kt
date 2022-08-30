package com.example.shopitemtest.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopitemtest.data.ShopListRepositoryImpl
import com.example.shopitemtest.domain.*

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListInteractor = GetShopListInteractor(repository)
    private val editShopListInteractor = EditShopItemInteractor(repository)
    private val deleteShopListInteractor = DeleteShopItemInteractor(repository)

    val shopList = getShopListInteractor.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopListInteractor.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopListInteractor.editShopItem(newItem)
    }
}