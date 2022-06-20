package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data_model.Body
import com.example.myapplication.databinding.ActivityItemBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.recycler_view.ProductAdapter
import kotlinx.android.synthetic.main.activity_item.view.*

class activity_item : AppCompatActivity() {
    lateinit var binding: ActivityItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityItemBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val itemRecibido=intent.getParcelableExtra<Body>("item")
        val image=intent.getStringExtra("image")
        binding.detalleProd.text=itemRecibido?.condition.toString()
        binding.tituloProd.text=itemRecibido?.title.toString()
        binding.detalleVendedor.text=itemRecibido?.currency_id.toString()
        binding.detallePrecio.text=itemRecibido?.price.toString()
        Glide.with(this).load(image).into(binding.imageProducto)


    }
}