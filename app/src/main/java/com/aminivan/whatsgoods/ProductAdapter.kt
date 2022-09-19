package com.aminivan.whatsgoods

import android.content.Context
import android.content.Intent
import android.icu.number.IntegerWidth
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aminivan.whatsgoods.databinding.ItemProductBinding

class ProductAdapter(var listProduct: ArrayList<DataProduct>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private lateinit var context : Context

    class ViewHolder(val binding : ItemProductBinding):RecyclerView.ViewHolder(binding.root){
        fun databind(itemData: DataProduct){
            binding.dataProduct = itemData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(listProduct[position])
        holder.binding.cvItem.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View?) {
                var bundle = Bundle()
                bundle.putString("productName",listProduct[position].nameProduct)
                bundle.putInt("imgProduct",listProduct[position].imgProduct)
                bundle.putInt("stockProduct",listProduct[position].stock)
                bundle.putString("descProduct",listProduct[position].descProduct)
                bundle.putInt("priceProduct",listProduct[position].priceProduct)
                Navigation.findNavController(holder.itemView).navigate(R.id.action_fragmentMain_to_fragmentDetails,bundle)

            }

        })
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    fun setDataProduct(productList : ArrayList<DataProduct>){
        this.listProduct = productList
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }
}