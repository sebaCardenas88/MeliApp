package com.example.myapplication.recycler_view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.myapplication.R
import com.example.myapplication.activity_item
import com.example.myapplication.data_model.Body
import com.example.myapplication.data_model.Content
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.RowItemBinding
import kotlin.coroutines.coroutineContext

class ProductAdapter(val listProducts:List<Body>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)

        return ProductViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val item = listProducts[position]



        holder.binding.nombreProducto.text = item.title
        holder.binding.precioProducto.text = item.price.toString()
        holder.binding.detalleProducto.text = item.condition
        holder.binding.zonaProducto.text = item.currency_id

      holder.bind(item.secure_thumbnail)


        //Pruebo q al hacer click sobre el producto, me muestre la posicion en el listado de items
        holder.binding.itemFila.setOnClickListener {
            //Toast.makeText(it.context, holder.adapterPosition.toString(), Toast.LENGTH_SHORT).show()
            //intent

            val intent = Intent(holder.binding.root.context, activity_item::class.java,)
            intent.putExtra("item",item)
            intent.putExtra("image",item.secure_thumbnail)
            holder.binding.nombreProducto.context.startActivity(intent)
        }


    }




    override fun getItemCount() = listProducts.size


    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Cargo el viewBinding
        val binding = RowItemBinding.bind(itemView)


        fun bind(image:String) {

            Glide.with(itemView.context).load(image).into(binding.imagenProducto)
        }

    }

}
