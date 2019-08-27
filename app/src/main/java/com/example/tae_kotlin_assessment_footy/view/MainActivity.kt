package com.example.tae_kotlin_assessment_footy.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tae_kotlin_assessment_footy.R
import com.example.tae_kotlin_assessment_footy.common.showToast
import com.example.tae_kotlin_assessment_footy.view.list.FootyList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_enter_footy_world.setOnClickListener {
            intent = Intent(this, FootyList::class.java)
            showToast(this,"clicked towards footy")
            startActivity(intent)

        }
//
//        btn_enter_sorting_paradigm.setOnClickListener {
//            intent = Intent(this,SortingActivity::class.java)
//            showToast(this,"clicked towards BubbleSort")
//            startActivity(intent)
//        }


    }
}
