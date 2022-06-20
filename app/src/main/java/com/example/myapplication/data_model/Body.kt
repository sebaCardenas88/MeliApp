package com.example.myapplication.data_model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
@Parcelize
data class Body(

    val condition: String,//detalle

    val currency_id: String, //zona

    val price: Double, // precio
   val secure_thumbnail: String,

    val title: String, //nombre producto


    //PROBANDO IMAGEN -- FALTA CARGAR URL
    val warranty: String
):Parcelable