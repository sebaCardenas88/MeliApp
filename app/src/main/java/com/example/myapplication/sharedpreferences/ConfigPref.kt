package com.example.myapplication.sharedpreferences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.myapplication.data_model.Body
import com.google.gson.Gson

class ConfigPref(val context:Context) {

    val ITEM_PREFERENCE_KEY="ITEM_PREFERENCE_KEY"

    fun saveData(body:Body){
        val pref=context.getSharedPreferences(ITEM_PREFERENCE_KEY,0)
        val editor=pref.edit()
        var json=Gson().toJson(body)
        editor.putString(ITEM_PREFERENCE_KEY,json)
        editor.apply()
    }


}