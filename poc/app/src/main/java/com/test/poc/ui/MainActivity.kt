package com.test.poc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.test.poc.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_content)
        supportFragmentManager.beginTransaction()
            .add(R.id.activity_container, ProductsFragment.newInstance(), "PRODUCT FRAGMENT TAG")
            .commitNow()
    }
}