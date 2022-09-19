package com.aminivan.whatsgoods

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelProduct : ViewModel() {
    val listProduct = arrayListOf(
        DataProduct("K70 PRO MINI WIRELESS 60% Mechanical CHERRY MX Speed Switch Keyboard with RGB Backlighting - Black",R.drawable.corsairk70,10,"The CORSAIR K70 PRO MINI WIRELESS RGB 60% Mechanical Gaming Keyboard is big on both performance and customization, equipped with hyper-fast, sub-1ms SLIPSTREAM WIRELESS and swappable CHERRY MX keyswitches in a portable profile.",200),
        DataProduct("K100 RGB Optical-Mechanical Gaming Keyboard - Midnight Gold",R.drawable.corsairk100,10,"The incomparable CORSAIR K100 RGB Optical-Mechanical Gaming Keyboard combines stunning gold-anodized dual-tone aluminum design, per-key RGB lighting with powerful CORSAIR AXON Hyper-Processing Technology, and CORSAIR OPX RGB keyswitches.",249),
        DataProduct("K70 RGB PRO Mechanical Gaming Keyboard with PBT DOUBLE SHOT PRO Keycaps — CHERRY® MX SPEED",R.drawable.corsairk70pro,10,"The K70 RGB PRO retains the iconic elements of our award-winning K70 series with a durable aluminum frame, CHERRY MX mechanical keyswitches, and per-key RGB backlighting, while setting a new bar for performance with AXON technology and a tournament switch.",200),
        DataProduct("K65 RGB MINI 60% Mechanical Gaming Keyboard — CHERRY MX Red — Black",R.drawable.corsairk65,10,"Access a robust set of side-printed onboard features, including over 30 unique controls for lighting, profiles, macros, media, volume, and mouse cursor Onboard macro recording and two function layers allow you to record macros on-the-fly to (FN + any key) or (FN + FN2 + any key) for convenient access to your advanced commands without sacrificing any standard keys.",109),
        DataProduct("K60 PRO TKL RGB Tenkeyless Optical-Mechanical Gaming Keyboard — CORSAIR OPX Switch — (NA)",R.drawable.keyboard,10,"The CORSAIR K60 PRO TKL RGB Tenkeyless Optical-Mechanical Gaming Keyboard delivers compact style and high performance, with CORSAIR OPX optical-mechanical keyswitches and a durable brushed aluminum frame",129),
        DataProduct("K60 RGB PRO Mechanical Gaming Keyboard – Azure Sea",R.drawable.corsairk60prorgb,10,"Programmable with CORSAIR iCUE Software namic RGB lighting control, sophisticated macro programming, and full system lighting synchronization compatible with CORSAIR peripherals, coolers, fans, and more. Experience an unparalleled level of immersion when playing iCUE-integrated games, as your RGB lighting dynamically reacts to in-game actions and events in real-time.",109),
        DataProduct("K70 RGB TKL CHAMPION SERIES Mechanical Gaming Keyboard — CHERRY MX SPEED",R.drawable.corsairk70rgbtkl,10,"Take the CORSAIR K70 RGB TKL Mechanical Gaming Keyboard to your next competition with a compact tenkeyless form- factor, pro-level performance powered by CORSAIR AXON hyper-processing technology, and a durable aluminum frame.",149),
        DataProduct("K55 RGB PRO Gaming Keyboard",R.drawable.corsairk55rgb,10,"The CORSAIR K55 RGB PRO Gaming Keyboard lights up your desktop with five-zone dynamic RGB backlighting and powers up your gameplay with six dedicated macro keys.",109),
        DataProduct("K95 RGB PLATINUM XT Mechanical Gaming Keyboard — CHERRY® MX SPEED (NA Layout)",R.drawable.corsairk96rgb,10,"Experience ultimate gaming freedom with the CORSAIR K63 Wireless Mechanical Gaming Keyboard, featuring ultra-fast 1ms 2.4GHz wireless technology with CHERRY® MX mechanical keyswitches packed into a portable, tenkeyless design.",109),
        DataProduct("K63 Wireless Mechanical Gaming Keyboard — Blue LED — CHERRY® MX Red",R.drawable.corsairk63,10,"Experience ultimate gaming freedom with the CORSAIR K63 Wireless Mechanical Gaming Keyboard, featuring ultra-fast 1ms 2.4GHz wireless technology with CHERRY® MX mechanical keyswitches packed into a portable, tenkeyless design.",200),
        DataProduct("K70 RGB MK.2 Mechanical Gaming Keyboard — CHERRY® MX Brown",R.drawable.corsairk70mk2,10,"The CORSAIR K70 RGB MK.2 is a premium mechanical gaming keyboard built to last, with an aluminum frame, CHERRY® MX keyswitches and stunning per-key RGB dynamic backlighting.",159)
    )

    val product : MutableLiveData<List<DataProduct>> = MutableLiveData()

    fun getProduct(){
        product.value = listProduct
    }
    fun setProduct(newlist : ArrayList<DataProduct>){
        product.value = newlist
    }

}