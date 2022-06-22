package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data_model.Body
import com.example.myapplication.data_model.BodyFavourites
import com.example.myapplication.databinding.ActivityItemBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.recycler_view.ProductAdapter
import com.example.myapplication.sharedpreferences.ConfigPref

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_item.*
import kotlinx.android.synthetic.main.activity_item.view.*
import java.lang.reflect.Type

class activity_item : AppCompatActivity() {

     var listaFav:ArrayList<Body> = ArrayList()

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


        //Mostrar data si hay algo cargado previamente
    // loadData()


      //OnClickLiatener

        binding.btnFavoritos.setOnClickListener {
          //  saveData(itemRecibido?.title,itemRecibido?.condition,itemRecibido?.currency_id,itemRecibido!!.price,itemRecibido.secure_thumbnail)

        }




    }
/*
    private fun loadData() {
        val sharedPreferences=applicationContext.getSharedPreferences("DATA",
            MODE_PRIVATE)
        val gson=Gson()
        val json=sharedPreferences.getString("product_item",null)

        val type= genericType<ArrayList<Body>>()
        listaFav=gson.fromJson(json,type)


    }
    inline fun <reified T> genericType() = object: TypeToken<T>() {}.type


    private fun saveData(title: String?, condition: String?, currencyId: String?,price: Double,secure_thumbnail:String) {
                    val sharedPreferences=applicationContext.getSharedPreferences("DATA",
                        MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        val gson=Gson()
        listaFav.add(Body(condition!!,currencyId!!,price,secure_thumbnail,title!!, warranty =""))
        val json=gson.toJson(listaFav)
        editor.putString("product_item",json)
        editor.apply()
        loadData()



    }
    */

/*
    private fun saveData() {
        val sharedPreferences=getSharedPreferences("shared preferences", 0)
        val editor=sharedPreferences.edit()
        val gson=Gson()
        val json=gson.toJson(listaFavoritos)
        editor.putString("task_list",json)
        editor.apply()

       // if (listaFavoritos==null){
         //   listaFavoritos= ArrayList()

        //}


    }
    inline fun <reified T> genericType() = object: TypeToken<T>() {}.type

    private fun loadData(){
        val sharedPreferences= getSharedPreferences("shared preferences", MODE_PRIVATE)
        val gson=Gson()
        val json=sharedPreferences.getString("task_list",null)

        val type=genericType<ArrayList<Body>>()
        listaFavoritos=gson.fromJson(json,type)

    }*/


}