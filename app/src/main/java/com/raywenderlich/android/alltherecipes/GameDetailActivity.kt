package com.raywenderlich.android.alltherecipes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_game_detail.*


class GameDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_detail)

        val name = intent.getStringExtra("name")
        game_list_name.text = name
        val price = intent.getStringExtra("price")
        game_list_price.text = price
        val release = intent.getStringExtra("release")
        game_list_release.text = release
        val discount = intent.getStringExtra("discount")
        game_list_discount1.text = discount
        val developer = intent.getStringExtra("developer")
        game_list_developer.text = developer
        val imageUrl = intent.getStringExtra("imageUrl")
        Picasso.get().load(imageUrl).into(game_pic)
        val platform = intent.getStringExtra("platform")
        game_list_platforms.text = platform
    }
}
