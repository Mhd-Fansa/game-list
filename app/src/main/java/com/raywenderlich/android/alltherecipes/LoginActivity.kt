package com.raywenderlich.android.alltherecipes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            if (username.text.toString() == "fansa" && password.text.toString() == "123") {
                val sharedPref = this.getSharedPreferences("login", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("username", username.text.toString())
                    apply()
                }
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this, "Username or Password is wrong", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onBackPressed() {
        val i = Intent(Intent.ACTION_MAIN)
        i.addCategory(Intent.CATEGORY_HOME)
        startActivity(i)
    }
}
