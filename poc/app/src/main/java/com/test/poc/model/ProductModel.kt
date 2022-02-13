package com.test.poc.model

import com.test.poc.interactions.IproductContract
import com.test.poc.model.datamodels.ProductDataModel

class ProductModel: IproductContract.Imodel {


    override fun getProductList(onFinishedListener: IproductContract.Imodel.OnFinishedListener) {
        //Add Dummy and return ProductData
        onFinishedListener.onFinished(addDummyData())
    }

    //ADD DUMMY DATA as per Json
    fun addDummyData(): ArrayList<ProductDataModel> {
        var productList: ArrayList<ProductDataModel> = arrayListOf()

        productList.addAll(listOf(
            ProductDataModel(consList = arrayListOf("Bad direction"),
            customerPrice = 120000.0,
            make= "Land Rover",
            marketPrice =  125000.0,
            model =  "Range Rover",
            prosList = arrayListOf("You can go everywhere", "Good sound system"),
            rating= 3),

            ProductDataModel(consList = arrayListOf("Bad direction"),
                customerPrice = 120000.0,
                make= "Land Rover",
                marketPrice =  125000.0,
                model =  "Range Rover",
                prosList = arrayListOf("You can go everywhere", "Good sound system"),
                rating= 2)
        ))
        return productList
    }


}