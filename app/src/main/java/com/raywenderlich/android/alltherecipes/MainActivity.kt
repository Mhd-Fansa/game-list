package com.raywenderlich.android.alltherecipes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.raywenderlich.android.alltherecipes.model.Reqres
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dataList : MutableList<com.raywenderlich.android.alltherecipes.model.Game> = mutableListOf()
    private lateinit var myAdapter: MyAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

      myAdapter = MyAdapter(dataList)

      game_list_view.layoutManager = LinearLayoutManager(this)
      game_list_view.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
      game_list_view.adapter = myAdapter

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
}
