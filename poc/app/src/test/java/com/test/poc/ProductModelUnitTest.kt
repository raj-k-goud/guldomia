package com.test.poc

import com.test.poc.model.datamodels.ProductDataModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ProductModelUnitTest {

    private lateinit var productList: ArrayList<ProductDataModel>

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        productList = arrayListOf(
            ProductDataModel(consList = arrayListOf("Bad direction"),
                customerPrice = 120000.0,
                make  ="Land Rover",
                marketPrice=  125000.0,
                model= "Range Rover",
                prosList= arrayListOf("You can go everywhere", "Good sound system"),
                rating= 3))
    }

    @Test
   fun testDataModel_Make(){
      val result = productList[0].make
        assertEquals("Land Rover", result)
        assertNotNull(productList)
   }

    @Test
    fun testDataModel_consList(){
        val result = productList[0].consList.size
        assertEquals(1, result)
    }

    @Test
    fun testDataModel_customerPrice(){
        val result = productList[0].customerPrice
        assertEquals(120000.0, result)
    }

    @Test
    fun testDataModel_marketPrice(){
        val result = productList[0].marketPrice
        assertEquals(125000.0, result)
    }

    @Test
    fun testDataModel_model(){
        val result = productList[0].model
        assertEquals("Range Rover", result)
    }

    @Test
    fun testDataModel_prosList(){
        val result = productList[0].prosList.size
        assertEquals(2, result)
    }

    @Test
    fun testDataModel_rating(){
        val result = productList[0].rating
        assertEquals(3, result)
    }
}