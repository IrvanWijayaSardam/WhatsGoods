package com.aminivan.whatsgoods

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelProduct : ViewModel() {
    val listProduct = arrayListOf(
        DataProduct("K70 PRO MINI WIRELESS 60% Mechanical CHERRY MX Speed Switch Keyboard with RGB Backlighting - Black",R.drawable.corsairk70,10,"The CORSAIR K70 PRO MINI WIRELESS RGB 60% Mechanical Gaming Keyboard is big on both performance and customization, equipped with hyper-fast, sub-1ms SLIPSTREAM WIRELESS and swappable CHERRY MX keyswitches in a portable profile.",200),
        DataProduct("K100 RGB Optical-Mechanical Gaming Keyboard - Midnight Gold",R.drawable.corsairk100,10,"The incomparable CORSAIR K100 RGB Optical-Mechanical Gaming Keyboard combines stunning gold-anodized dual-tone aluminum design, per-key RGB lighting with powerful CORSAIR AXON Hyper-Processing Technology, and CORSAIR OPX RGB keyswitches.",249),
        DataProduct("Monitor Laptop 24 Inch",R.drawable.keyboard,10,"SAMSUNG MONITOR LED 24 INCH CURVED 140Hz",200),
        DataProduct("Monitor Laptop 24 Inch",R.drawable.keyboard,10,"SAMSUNG MONITOR LED 24 INCH CURVED 140Hz",200),
        DataProduct("Monitor Laptop 24 Inch",R.drawable.keyboard,10,"SAMSUNG MONITOR LED 24 INCH CURVED 140Hz",200),
        DataProduct("Monitor Laptop 24 Inch",R.drawable.keyboard,10,"SAMSUNG MONITOR LED 24 INCH CURVED 140Hz",200),
        DataProduct("Monitor Laptop 24 Inch",R.drawable.keyboard,10,"SAMSUNG MONITOR LED 24 INCH CURVED 140Hz",200),
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