package com.aminivan.whatsgoods

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import com.aminivan.whatsgoods.databinding.FragmentDetailsBinding


class FragmentDetails : Fragment() {

    lateinit var binding : FragmentDetailsBinding
    lateinit var productName : String
    var imgProduct = 0
    var stockProduct = 0
    lateinit var descProduct : String
    var priceProduct = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater,container,false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        getDataBundle()
        binding.btnBuy.setOnClickListener(){
            gotoWhatsApp(productName,priceProduct.toString())
        }
    }
    fun getDataBundle(){
        productName = arguments?.getString("productName").toString()
        imgProduct = arguments?.getInt("imgProduct")!!
        stockProduct = arguments?.getInt("stockProduct")!!
        descProduct = arguments?.getString("descProduct").toString()
        priceProduct = arguments?.getInt("priceProduct")!!

        dataBind(DataProduct(productName.toString(),imgProduct,stockProduct,descProduct.toString(),priceProduct))

    }

    fun gotoWhatsApp(productName: String,price: String){
        val url = "https://wa.me/6281340691423/?text=Halo%20saya%20berminat%20membeli%20barang%20$productName%20dengan%20harga$%20$price"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    fun dataBind(itemData : DataProduct){
        binding.detailProduct = itemData
    }
    override fun onPrepareOptionsMenu(menu: Menu) {
        menu!!.findItem(R.id.search_action).setVisible(false)
        super.onPrepareOptionsMenu(menu)
    }
}