package com.test.poc.presenter

import android.util.Log
import com.test.poc.interactions.IproductContract
import com.test.poc.model.ProductModel
import com.test.poc.model.datamodels.ProductDataModel

class ProductPresenter(productView: IproductContract.Iview) : IproductContract.IPresenter, IproductContract.Imodel.OnFinishedListener {

      var productView: IproductContract.Iview  = productView
      var  productModel: IproductContract.Imodel =ProductModel()

    override fun requestProductData() {
       productModel.getProductList(this)
    }

    override fun onFinished(productsList: ArrayList<ProductDataModel>) {
        productView?.setProductData(productsList)
    }
}