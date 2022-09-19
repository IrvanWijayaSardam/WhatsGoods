package com.aminivan.whatsgoods

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aminivan.whatsgoods.databinding.FragmentMainBinding
import java.util.*
import kotlin.collections.ArrayList


class FragmentMain : Fragment() {

    lateinit var binding : FragmentMainBinding
    private lateinit var tempArray: ArrayList<DataProduct>
    private lateinit var newArrayList : ArrayList<DataProduct>
    private lateinit var newRecyleView : RecyclerView
    private lateinit var arrayWords: ArrayList<DataProduct>
    private lateinit var arrayProduct: ArrayList<DataProduct>

    lateinit var rvProduct : RecyclerView
    lateinit var productVM : ViewModelProduct
    lateinit var productAdapter : ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        arrayProduct = arrayListOf()
        newArrayList = arrayListOf()
        tempArray = arrayListOf()
        setRecycle()
    }

    fun setRecycle(){
        productVM = ViewModelProvider(this).get(ViewModelProduct::class.java)
        productVM.getProduct()
        productVM.product.observe(viewLifecycleOwner, Observer {
            productAdapter.setDataProduct(it as ArrayList<DataProduct>)
        })
        arrayProduct.addAll(productVM.listProduct)
        newArrayList.addAll(arrayProduct)
        tempArray.addAll(arrayProduct)


        rvProduct = binding.rvproduct
        productAdapter = ProductAdapter(tempArray)

        rvProduct.layoutManager = GridLayoutManager(context, 2)
        rvProduct.adapter = productAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)  {
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
        super.onCreateOptionsMenu(menu, inflater)

    }

}