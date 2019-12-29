package com.example.storevarialblesinsharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var spe:SharedPreferences.Editor? = null
    var sp:SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_save.setOnClickListener {
            save()
        }
        bt_load.setOnClickListener {
            load()
        }
    }//onCreate()

    @SuppressLint("CommitPrefEdits")
    fun save(){

        spe = getSharedPreferences("sp", Context.MODE_PRIVATE).edit()
        spe?.putString("text",et_text.text.toString())
        spe?.putBoolean("isChecked",sw.isChecked)
        spe?.apply()
        Toast.makeText(this,"saved",Toast.LENGTH_LONG).show()

    }

    fun load(){
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE)
        var text = sp?.getString("text","your text....")
        var isCheckedd = sp?.getBoolean("isChecked",false)

        tv_text.setText(text)
        et_text.setText(text)
        sw.isChecked = isCheckedd!!

    }

}//MainActivity

