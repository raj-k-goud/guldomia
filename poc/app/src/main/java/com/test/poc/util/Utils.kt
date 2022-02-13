package com.test.poc.util

class Utils {

    companion object {

    fun formatPrice(price: Double?): String {
            if (price != null) {
                if(price <= 0){
                    return "Not Available"
                }else{
                    return ((price/1000).toInt()).toString() + "K"
                }
            }
        return "Not Available"
    }
}
}