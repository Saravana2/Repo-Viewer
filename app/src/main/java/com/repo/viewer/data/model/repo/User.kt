package com.repo.viewer.data.model.repo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class User(
    @PrimaryKey
    @SerializedName("id")
    var id: Long,
    @SerializedName("login")
    var login: String,
    @SerializedName("node_id")
    var nodeId: String,
    @SerializedName("avatar_url")
    var avatarUrl: String,
    @SerializedName("html_url")
    var htmlUrl: String,
    @SerializedName("type")
    var type: String,
)