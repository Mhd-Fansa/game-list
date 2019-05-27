package com.raywenderlich.android.alltherecipes.model

import com.google.gson.annotations.SerializedName


data class Reqres(
        @SerializedName("games")
        val games: List<Game>
)