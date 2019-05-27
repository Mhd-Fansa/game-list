package com.raywenderlich.android.alltherecipes.model


import com.google.gson.annotations.SerializedName

data class Game(
        @SerializedName("developer")
        val developer: String,
        @SerializedName("discountPrice")
        val discountPrice: String,
        @SerializedName("imageUrl")
        val imageUrl: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("Platforms")
        val platforms: List<Platform>,
        @SerializedName("price")
        val price: String,
        @SerializedName("release")
        val release: String
)