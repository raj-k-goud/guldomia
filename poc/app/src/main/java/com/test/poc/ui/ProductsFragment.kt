package com.test.poc.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.poc.R
import com.test.poc.adapter.ProductsAdapter
import com.test.poc.interactions.IproductContract
import com.test.poc.model.datamodels.ProductDataModel
import com.test.poc.presenter.ProductPresenter

class ProductsFragment: Fragment(), IproductContract.Iview  {

    var productsRecycleView: RecyclerView? = null
    private var productList: ArrayList<ProductDataModel> = ArrayList()
    private var productsAdapter: ProductsAdapter? = null
    private var presenter: ProductPresenter? = null

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ProductPresenter(this)
        presenter?.let {
            it.requestProductData()
        }
    }
    @Override
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view: View = inflater.inflate(R.layout.fragment_content, container, false)
        return initUI(view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun initUI(view: View): View {
        productsRecycleView = view.findViewById(R.id.products_rv)
        productsAdapter = ProductsAdapter(productList)
        productsRecycleView?.let { it
            it.layoutManager = LinearLayoutManager(activity?.applicationContext)
            it.adapter = productsAdapter
        }
        return view
    }

    override fun setProductData(productsList: ArrayList<ProductDataModel>) {
        productList.addAll(productsList)
        productsAdapter?.notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProductsFragment()
    }

}