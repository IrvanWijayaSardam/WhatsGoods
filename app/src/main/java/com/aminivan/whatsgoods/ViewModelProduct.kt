package com.aminivan.whatsgoods

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelProduct : ViewModel() {
    val listProduct = arrayListOf(
        DataProduct("Monitor Laptop 24 Inch",R.drawable.keyboard,10,"SAMSUNG MONITOR LED 24 INCH CURVED 140Hz",200),
        DataProduct("Monitor Laptop 24 Inch",R.drawable.keyboard,10,"SAMSUNG MONITOR LED 24 INCH CURVED 140Hz",200),
        DataProduct("Monitor Laptop 24 Inch",R.drawable.keyboard,10,"SAMSUNG MONITOR LED 24 INCH CURVED 140Hz",200),
        DataProduct("Monitor Laptop 24 Inch",R.drawable.keyboard,10,"SAMSUNG MONITOR LED 24 INCH CURVED 140Hz",200)
    )

    val product : MutableLiveData<List<DataProduct>> = MutableLiveData()

    fun getProduct(){
        product.value = listProduct
    }
}