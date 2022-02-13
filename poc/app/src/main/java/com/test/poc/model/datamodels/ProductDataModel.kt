package com.test.poc.model.datamodels

data class ProductDataModel(

    var consList: ArrayList<String> = arrayListOf(),
    var customerPrice: Double? = null,
    var make: String? = null,
    var marketPrice: Double? = null,
    var model: String? = null,
    var prosList : ArrayList<String> = arrayListOf(),
    var rating: Int? = null
)
