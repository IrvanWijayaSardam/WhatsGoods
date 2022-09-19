package com.aminivan.whatsgoods

import android.R
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aminivan.whatsgoods.databinding.ActivityDetailBinding
import java.net.URLEncoder


class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    lateinit var productName: String
    var imgProduct: Int = 0
    var stockProduct: Int = 0
    lateinit var descProduct: String
    var priceProduct: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataBundle()
        binding.btnBuy.setOnClickListener(){
            gotoWhatsApp(productName,priceProduct.toString())
        }
    }

    fun getDataBundle(){
        var bund = intent.extras
        productName = bund!!.getString("productName").toString()
        imgProduct = bund!!.getInt("imgProduct")
        stockProduct = bund!!.getInt("stockProduct")
        descProduct = bund!!.getString("descProduct").toString()
        priceProduct = bund!!.getInt("priceProduct")

        databind(DataProduct(productName.toString(),imgProduct,stockProduct,descProduct.toString(),priceProduct))
    }

    fun databind(itemData: DataProduct){
        binding.detailProduct = itemData
    }

    fun gotoWhatsApp(productName: String,price: String){
        val url = "https://wa.me/6281340691423/?text=Halo%20saya%20berminat%20membeli%20barang%20$productName%20dengan%20harga$%20$price"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}