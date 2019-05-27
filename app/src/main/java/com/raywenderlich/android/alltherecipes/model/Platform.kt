package com.raywenderlich.android.alltherecipes.model

import com.google.gson.annotations.SerializedName


data class Platform(
        @SerializedName("name")
        val name: String,
        @SerializedName("NumberOfSales")
        val numberOfSales: Int
)