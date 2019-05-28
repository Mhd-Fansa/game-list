package com.raywenderlich.android.alltherecipes

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.raywenderlich.android.alltherecipes.model.Game
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_game_detail.view.*
import kotlinx.android.synthetic.main.list_item_game.view.*
import kotlinx.android.synthetic.main.list_item_game.view.game_list_name
import kotlinx.android.synthetic.main.list_item_game.view.game_list_price
import kotlinx.android.synthetic.main.list_item_game.view.game_pic

class MyAdapter(private val dataList: MutableList<Game>) : RecyclerView.Adapter<MyHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_game, parent, false)
        val holder = MyHolder(view)
        view.setOnClickListener{
            val intent = Intent(context, GameDetailActivity::class.java)
            intent.putExtra("name", dataList[holder.adapterPosition].name)
            intent.putExtra("price", dataList[holder.adapterPosition].price)
            intent.putExtra("developer", dataList[holder.adapterPosition].developer)
            intent.putExtra("discount", dataList[holder.adapterPosition].discountPrice)
            intent.putExtra("release", dataList[holder.adapterPosition].release)
            intent.putExtra("imageUrl", dataList[holder.adapterPosition].imageUrl)
            context.startActivity(intent)
        }
        return holder
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = dataList[position]

        val gameNameTextView = holder.itemView.game_list_name
        val gamePicImageView = holder.itemView.game_pic
        val gamePriceTextView = holder.itemView.game_list_price
        val gameDiscountTextView = holder.itemView.game_list_discount
//        val gameDeveloperTextView = holder.itemView.game_list_developer
//        val gameReleaseTextView = holder.itemView.game_list_release

        val gameNameTypeFace = ResourcesCompat.getFont(context, R.font.josefinsans_bold)
        gameNameTextView.typeface = gameNameTypeFace

        val gamePriceTypeFace = ResourcesCompat.getFont(context, R.font.josefinsans_semibolditalic)
        gamePriceTextView.typeface = gamePriceTypeFace

        val gameDiscountTypeFace = ResourcesCompat.getFont(context, R.font.quicksand_bold)
        gameDiscountTextView.typeface = gameDiscountTypeFace

        val name = "${data.name}"
        gameNameTextView.text = name
        val price = "${data.price}"
        gamePriceTextView.text = price
        val discount = "${data.discountPrice}"
        gameDiscountTextView.text = discount.orEmpty()
//        val developer = "${data.developer}"
//        gameDeveloperTextView.text = developer
//        val release = "${data.release}"
//        gameReleaseTextView.text = release

        Picasso.get().load(data.imageUrl).into(gamePicImageView)

    }
}