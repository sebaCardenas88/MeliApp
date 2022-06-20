package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import com.example.myapplication.data_model.Body

class activity_item : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val itemRecibido=intent.getParcelableExtra<Body>("item")
        Log.d("ItemRecibido",itemRecibido!!.title)
        Log.d("ItemRecibido",itemRecibido.price.toString())
        Log.d("ItemRecibido",itemRecibido.condition)
    }
}