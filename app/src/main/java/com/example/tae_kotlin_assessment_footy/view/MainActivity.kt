package com.example.tae_kotlin_assessment_footy.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tae_kotlin_assessment_footy.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_enter_footy_world.setOnClickListener {
            intent = Intent(this,FootyDetailsInfo::class.java)
            startActivity(intent)
        }


    }
}
