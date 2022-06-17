package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.api_service.RetrofitInstance
import com.example.myapplication.data_model.Body
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

    initRecyclerView()
        //Activo el buscador
        binding.svProducts.setOnQueryTextListener(this)


    }

    private fun initRecyclerView(){
        adapter= ProductAdapter(productsImages)
        binding.recyclerProductos.layoutManager=LinearLayoutManager(this)
        binding.recyclerProductos.adapter=adapter


    }

    fun searchProduct(query:String){
        CoroutineScope(Dispatchers.IO).launch{
            //hago llamada a la API de predictor de categorias
            val call=RetrofitInstance.api.getCategoryPredictor(query)
            //Guardo respuesta d la llamada
            val predictorResponse=call.body()!!

                if (call.isSuccessful) {
                    var listado:String=""
                    Log.d("Respuestapredictor", predictorResponse[0].domain_name)
                    val categoryId=predictorResponse[0].category_id
                    val callTop20=RetrofitInstance.api.getTwentyproducts(categoryId)
                    val callTop20Response=callTop20.body()!!
                    if (callTop20.isSuccessful) {
                        Log.d("Respuesta20Productos", callTop20Response.content.toString())
                        var listarItems = mutableListOf<String>()
                        for (producto in callTop20Response.content) {
                            Log.d("Producto Individual", producto.type)
                            listarItems.add(producto.id)

                            listado = listarItems.joinToString(",")
                            Log.d("listaItems", listado)
                        }

                        //Lamadas a los productos

                       /**
                        val callItems = RetrofitInstance.api.getItems(listado)
                        val getItemsResponse = callItems.body()!!


                        if (callItems.isSuccessful) {

                            for (body in callItems.body()!!) {

                                Log.d("itemPrecio", body.body.price.toString())
                            }

                            // Log.d("items",callItems.body().toString())
                        } else {
                            //Log.d("error","shiiiiiiittttt")
                        }
*/

                    }else{
                        Log.d("HiceCagadas20000", "aiuuddaaaaa20000")
                    }
                } else {
                    Log.d("HiceCagadas", "aiuuddaaaaa")
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

//Carga manual de productos
/**
productsImages= mutableListOf(Body("dasdad","dsadasd",22.2,"sdsds","https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg")
,Body("dasdad","dsadasd",22.2,"sdsds","https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg")
,Body("dasdad","dsadasd",22.2,"sdsds","https://images.dog.ceo/breeds/hound-afghan/n02088094_10263.jpg")
,Body("dasdad","dsadasd",22.2,"sdsds","https://images.dog.ceo/breeds/hound-afghan/n02088094_10715.jpg")
,Body("dasdad","dsadasd",22.2,"sdsds","https://images.dog.ceo/breeds/hound-afghan/n02088094_10822.jpg")
,Body("dasdad","dsadasd",22.2,"sdsds","https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg")
,Body("dasdad","dsadasd",22.2,"sdsds","https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg")
,Body("dasdad","dsadasd",22.2,"sdsds","https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg")
,Body("dasdad","dsadasd",22.2,"sdsds","https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg")
,Body("dasdad","dsadasd",22.2,"sdsds","https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg")
,Body("dasdad","dsadasd",22.2,"sdsds","https://images.dog.ceo/breeds/hound-afghan/n02088094_1007.jpg"))*/