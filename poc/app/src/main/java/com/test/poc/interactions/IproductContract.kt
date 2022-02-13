package com.test.poc.interactions

import com.test.poc.model.datamodels.ProductDataModel


class IproductContract {

    interface Imodel{
        interface OnFinishedListener {
            fun onFinished(productsList: ArrayList<ProductDataModel>)
        }
        fun getProductList(onFinishedListener: OnFinishedListener )
    }

    interface Iview{
        fun setProductData(productsList: ArrayList<ProductDataModel>)
    }

    interface IPresenter{
        fun requestProductData()
    }
}