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

                    /**
                     * This is the adapter for the RecyclerView
                     * */
    class ProductAdapter(val listProducts:List<Body>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

                    val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)

                    return ProductViewHolder(layout)
                }


                override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

                    val item = listProducts[position]

                    holder.binding.nombreProducto.text = item.title
                    holder.binding.precioProducto.text = "$ ${item.price}0"
                    holder.binding.detalleProducto.text = item.condition
                    holder.binding.zonaProducto.text = item.currency_id
                    holder.bind(item.pictures[0].secure_url)


                  /**
                   * When the user click over the item,this opens the next activity and pass the clicked item information
                   * */
                    holder.binding.itemFila.setOnClickListener {
                        val intent = Intent(holder.binding.root.context, activity_item::class.java,)
                        intent.putExtra("item",item)
                        holder.binding.nombreProducto.context.startActivity(intent)
                    }

            }

                    override fun getItemCount() = listProducts.size


    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

                    val binding = RowItemBinding.bind(itemView)

                    /**
                     * This function is for loading images in the adapter
                                 * */
                    fun bind(image:String) {

                        Glide.with(itemView.context).load(image).into(binding.imagenProducto)
                    }

    }

}
