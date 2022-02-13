package com.test.poc.model

import com.test.poc.interactions.IproductContract
import com.test.poc.model.datamodels.ProductDataModel

class ProductModel: IproductContract.Imodel {


    override fun getProductList(onFinishedListener: IproductContract.Imodel.OnFinishedListener) {
        //Add Dummy and return ProductData
        //TODO: Make Network/api Call and fetch the data
        onFinishedListener.onFinished(addDummyData())
    }

    //ADD DUMMY DATA as per Json
    fun addDummyData(): ArrayList<ProductDataModel> {
        var productList: ArrayList<ProductDataModel> = arrayListOf()
        productList.addAll(listOf(
            ProductDataModel(consList = arrayListOf("Bad direction"),
            customerPrice = 120000.0,
            make  ="Land Rover",
            marketPrice=  125000.0,
            model= "Range Rover",
            prosList= arrayListOf("You can go everywhere", "Good sound system"),
            rating= 3),
            ProductDataModel(consList = arrayListOf("Sometime explode"),
            customerPrice= 220000.0,
            make= "Alpine",
            marketPrice= 225000.0,
            model= "Roadster",
            prosList= arrayListOf("This car is so fast", "Jame Bond would love to steal that car", "", ""),
            rating= 4),
            ProductDataModel(consList= arrayListOf("You can heard the engine over children cry at the back", "", "You may lose this one if you divorce"),
            customerPrice= 65000.0,
            make= "BMW",
            marketPrice= 55900.0,
            model= "3300i",
            prosList= arrayListOf("Your average business man car", "Can bring the family home safely", "The city must have"),
            rating= 5),
            ProductDataModel(consList= arrayListOf("You can heard the engine over children cry at the back", "", "You may lose this one if you divorce"),
            customerPrice= 95000.0,
            make= "Mercedes Benz",
            marketPrice= 85900.0,
            model= "GLE coupe",
            prosList= arrayListOf(),
            rating= 2)
            ))
        
        return productList
    }


}