package com.repo.viewer.data.model.repo

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.repo.viewer.data.db.typeconvertor.UserListTypeConvertor

@Entity(tableName = "repository")
data class Repository(
    @PrimaryKey
    @SerializedName("id")
    var id: Long,
    @SerializedName("node_id")
    var nodeId: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("full_name")
    var fullName: String,
    @SerializedName("html_url")
    var htmlUrl: String,
    @SerializedName("description")
    var description: String?,
    @SerializedName("fork")
    var fork: Boolean,
    @SerializedName("url")
    var url: String,
    @TypeConverters(UserListTypeConvertor::class)
    @SerializedName("owner")
    var owner: User,
)