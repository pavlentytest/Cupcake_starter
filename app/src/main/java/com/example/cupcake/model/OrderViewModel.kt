package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val PRICE_PER_CUPCAKE = 2.00

class OrderViewModel: ViewModel() {

    private val _quantity = MutableLiveData<Int>(0)
    val quantity: LiveData<Int> = _quantity

    private val _flavor = MutableLiveData<String>("")
    val flavor: LiveData<String> = _flavor

    private val _date = MutableLiveData<String>("")
    val date: LiveData<String> = _date

    private val _price = MutableLiveData<Double>(0.0)
    val price: LiveData<Double> = _price

    fun setQuantity(numberUpcakes: Int) {
        _quantity.value = numberUpcakes
        updatePrice()
    }
    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    private fun updatePrice() {
        val calculatedPrice = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
        _price.value = calculatedPrice
    }
}