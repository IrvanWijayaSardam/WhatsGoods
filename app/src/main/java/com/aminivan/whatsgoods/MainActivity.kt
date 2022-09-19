package com.aminivan.whatsgoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.widget.GridLayout
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aminivan.whatsgoods.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var rvProduct : RecyclerView
    lateinit var productVM : ViewModelProduct
    lateinit var productAdapter : ProductAdapter

    lateinit var menuMain: Menu

    private lateinit var tempArray: ArrayList<DataProduct>
    private lateinit var newArrayList : ArrayList<DataProduct>
    private lateinit var arrayProduct: ArrayList<DataProduct>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.layoutToolbar)
        arrayProduct = arrayListOf()
        newArrayList = arrayListOf()
        tempArray = arrayListOf()
        setRecycle()
    }
    fun setRecycle(){
        productVM = ViewModelProvider(this).get(ViewModelProduct::class.java)
        productVM.getProduct()
        productVM.product.observe(this, Observer {
            productAdapter.setDataProduct(it as ArrayList<DataProduct>)
        })
        arrayProduct.addAll(productVM.listProduct)
        newArrayList.addAll(arrayProduct)
        tempArray.addAll(arrayProduct)


        rvProduct = binding.rvProduct
        productAdapter = ProductAdapter(tempArray)

        rvProduct.layoutManager = GridLayoutManager(this, 2)
        rvProduct.adapter = productAdapter
    }


    override fun onCreateOptionsMenu(menu: Menu) : Boolean {
        this.menuMain = menu
        menuInflater.inflate(R.menu.menu,menu)
        val item = menu.findItem(R.id.search_action)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(newText: String?): Boolean {
                tempArray.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if(searchText.isNotEmpty()){
                    newArrayList.forEach{
                        if (it.nameProduct.toLowerCase(Locale.getDefault()).contains(searchText)){
                            tempArray.add(it)
                            productVM.setProduct(tempArray)
                            productAdapter.setDataProduct(tempArray)
                        }
                    }
                    productAdapter.notifyDataSetChanged()
                }
                else{
                    tempArray.clear()
                    tempArray.addAll(newArrayList)
                    productAdapter.notifyDataSetChanged()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempArray.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if(searchText.isNotEmpty()){

                    newArrayList.forEach{
                        if (it.nameProduct.toLowerCase(Locale.getDefault()).contains(searchText)){
                            tempArray.add(it)
                            productVM.setProduct(tempArray)
                            productAdapter.setDataProduct(tempArray)
                        }
                        else {
                            Log.e("ElseOnQueryTextChange : ",searchText)
                        }
                    }
                    productAdapter.notifyDataSetChanged()
                }
                else{
                    tempArray.clear()
                    tempArray.addAll(newArrayList)
                    productAdapter.notifyDataSetChanged()

                }
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}