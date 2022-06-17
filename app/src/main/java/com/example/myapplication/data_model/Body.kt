package com.example.myapplication.data_model

data class Body(
    //val accepts_mercadopago: Boolean,
    //val automatic_relist: Boolean,
   // val available_quantity: Int,
    //val base_price: Double,
    //val buying_mode: String,
    //val catalog_listing: Boolean,
    //val catalog_product_id: Any,
    //val category_id: String,
    //val channels: List<String>,
    val condition: String,//detalle
    //val coverage_areas: List<Any>,
    val currency_id: String, //zona
    //val date_created: String,
    //val deal_ids: List<String>,
    /**val descriptions: List<Any>,
    val differential_pricing: Any,
    val domain_id: String,
    val health: Double,
    val id: String,
    val initial_quantity: Int,
    val international_delivery_mode: String,
    val last_updated: String,
    val listing_source: String,
    val listing_type_id: String,
    val non_mercado_pago_payment_methods: List<Any>,
    val official_store_id: Int,
    val original_price: Int,
    val parent_item_id: Any,
    val permalink: String,
    val pictures: List<Picture>,*/
    val price: Double, // precio
    /**val secure_thumbnail: String,
    val seller_contact: Any,
    val seller_id: Int,
    val site_id: String,
    val sold_quantity: Int,
    val start_time: String,
    val status: String,
    val stop_time: String,
    val sub_status: List<Any>,
    val subtitle: Any,
    val tags: List<String>,
    val thumbnail: String,
    val thumbnail_id: String,*/
    val title: String, //nombre producto
    /**val video_id: Any,
    val warnings: List<Any>,*/

    //PROBANDO IMAGEN -- FALTA CARGAR URL
    val warranty: String
)