package com.example.data.datasourcess.local.converter

import androidx.room.TypeConverter
import com.example.data.model.response.Creator
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ListCreatorsConverter {

    @TypeConverter
    fun fromList(list:List<Creator>?):String?{
        val gson = Gson()
        return if (list != null) gson.toJson(list) else null
    }

    @TypeConverter
    fun toList(list:String?):List<Creator>?{
        val listType: Type = object : TypeToken<ArrayList<Creator?>?>() {}.type
        return if (list != null) Gson().fromJson(list, listType) else null
    }
}