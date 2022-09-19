package com.aminivan.whatsgoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aminivan.whatsgoods.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var rvProduct : RecyclerView
    lateinit var productVM : ViewModelProduct
    lateinit var productAdapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setRecycle()

        productVM = ViewModelProvider(this).get(ViewModelProduct::class.java)
        productVM.getProduct()
        productVM.product.observe(this, Observer {
            productAdapter.setDataProduct(it as ArrayList<DataProduct>)
        })
    }
    fun setRecycle(){
        rvProduct = binding.rvProduct
        productAdapter = ProductAdapter(ArrayList())

        rvProduct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvProduct.adapter = productAdapter
    }
}