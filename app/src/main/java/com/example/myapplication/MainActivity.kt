package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.api_service.RetrofitInstance
import com.example.myapplication.data_model.Body
import com.example.myapplication.data_model.ItemResponse
import com.example.myapplication.data_model.Picture
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.recycler_view.ProductAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:ProductAdapter
    private var productsImages= mutableListOf<Body>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        /**Inite the RecyclerView*/
        initRecyclerView()
        /**Whit this, activate the search view*/
        binding.svProducts.setOnQueryTextListener(this)

    }

    private fun initRecyclerView(){
        adapter= ProductAdapter(productsImages)
        binding.recyclerProductos.layoutManager=LinearLayoutManager(this)
        binding.recyclerProductos.adapter=adapter


    }

    fun searchProduct(query:String){

        binding.textoError.visibility=View.GONE
        binding.recyclerProductos.visibility=View.VISIBLE

        CoroutineScope(Dispatchers.IO).launch{
            //hago llamada a la API de predictor de categorias
            val call=RetrofitInstance.api.getCategoryPredictor(query)
            //Guardo respuesta d la llamada
            val predictorResponse=call.body()
            if (!predictorResponse.isNullOrEmpty()){
                if (call.isSuccessful) {
                    var listado:String=""
                    Log.d("Respuestapredictor", predictorResponse[0].domain_name)
                    val categoryId=predictorResponse[0].category_id
                    val callTop20=RetrofitInstance.api.getTwentyproducts(categoryId)







                    val callTop20Response=callTop20.body()
                    if (callTop20.isSuccessful) {
                        Log.d("Respuesta20Productos", callTop20Response!!.content.toString())
                        var listarItems = mutableListOf<String>()
                        for (product in callTop20Response!!.content) {
                            Log.d("Producto Individual", product.type)

                             if (product.type.equals("ITEM"))
                                listarItems.add(product.id)

                            listado = listarItems.joinToString(",")
                            Log.d("listaItems", listado)
                        }
//Desde aca para comentar
                        //Lamadas a los productos


                        val callItems = RetrofitInstance.api.getItems(listado)
                        val getItemsResponse:List<ItemResponse>? = callItems.body()

                        runOnUiThread {
                            if (callItems.isSuccessful){
                                productsImages.clear()
                                if (!getItemsResponse.isNullOrEmpty()) {
                                    for (i in getItemsResponse){

                                        productsImages.add(i.body)

                                    }
                                }
                                adapter.notifyDataSetChanged()
                            }
                            //Intent para pasar a la otra pagina




                        }/*
                        if (callItems.isSuccessful) {



/*
                            for (body in callItems.body()!!) {

                                if (!body.body.title.isNullOrEmpty()){
                                Log.d("itemPrecio", body.body.title)}

                            }

                            // Log.d("items",callItems.body().toString())
  */                      } else {
                            showError()
                        }*/


                        //hasta aca
                    }else{
                        runOnUiThread {
                            binding.textoError.visibility = View.VISIBLE
                            binding.recyclerProductos.visibility = View.GONE
                        }
                    }
                } }else {
                    runOnUiThread {
                        binding.textoError.visibility = View.VISIBLE
                        binding.recyclerProductos.visibility = View.GONE
                    }
                }


        }

    }
    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){
            searchProduct(query.toLowerCase())
        }
        return true
    }


    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}


