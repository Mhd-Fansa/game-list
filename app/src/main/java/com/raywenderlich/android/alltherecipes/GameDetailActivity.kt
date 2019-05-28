package com.raywenderlich.android.alltherecipes

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.raywenderlich.android.alltherecipes.model.Game
import com.raywenderlich.android.alltherecipes.model.Reqres
import kotlinx.android.synthetic.main.list_detail_game.*

class GameDetailActivity : AppCompatActivity() {

    private val dataList : MutableList<com.raywenderlich.android.alltherecipes.model.Game> = mutableListOf()
    private lateinit var myAdapter: MyAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_detail_game)

        myAdapter = MyAdapter2(dataList)

        game_listDetail_view.layoutManager = LinearLayoutManager(this)
        game_listDetail_view.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        game_listDetail_view.adapter = myAdapter

        AndroidNetworking.initialize(this)

        AndroidNetworking.get("https://next.json-generator.com/api/json/get/E1De4F4pI").build()
                .getAsObject(Reqres::class.java, object : ParsedRequestListener<Reqres> {
                    override fun onResponse(response: Reqres) {
                        dataList.addAll(response.games)
                        myAdapter.notifyDataSetChanged()
                    }

                    override fun onError(anError: ANError?) {

                    }

                })


    }

    companion object {
        const val EXTRA_TITLE = "name"

        fun newIntent(context: Context, game: Game): Intent {
            val detailIntent = Intent(context, GameDetailActivity::class.java)

            detailIntent.putExtra(EXTRA_TITLE, game.name)

            return detailIntent
        }
    }
}
