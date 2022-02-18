package com.repo.viewer.data.db.typeconvertor

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.repo.viewer.data.model.repo.User

class UserListTypeConvertor {
    private val gson = Gson()

    @TypeConverter
    fun objectToString(data: User?): String = gson.toJson(data)

    @TypeConverter
    fun stringToObject(data: String?): User {
        return gson.fromJson(data, User::class.java)
    }
}