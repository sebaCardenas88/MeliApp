package com.example.myapplication.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data_model.Body
import com.example.myapplication.data_model.Content
import com.example.myapplication.databinding.RowItemBinding

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
        //FALTA CARGAR IMAGEN EN ADAPTER!!!!!!!!!
//        holder.bind(item.warranty)
        holder.binding.itemFila.setOnClickListener { Toast.makeText(it.context,"Hola",Toast.LENGTH_SHORT).show()}

    }

    override fun getItemCount() = listProducts.size


    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Cargo el viewBinding
        val binding = RowItemBinding.bind(itemView)


        fun bind(warranty:String) {

            Glide.with(itemView.context).load(warranty).into(binding.imagenProducto)
        }

    }

}
