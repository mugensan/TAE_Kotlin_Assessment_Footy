package com.example.tae_kotlin_assessment_footy.view

import android.os.AsyncTask
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tae_kotlin_assessment_footy.R
import com.example.tae_kotlin_assessment_footy.common.showToast
import kotlinx.android.synthetic.main.sorting_paradigm_layout.*
import java.lang.Exception
import java.lang.ref.WeakReference
import java.security.AccessControlContext
import java.util.ArrayList
import java.util.Arrays.sort







class SortingActivity : AppCompatActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sorting_paradigm_layout)


        btn_sort.setOnClickListener() {

            val task = getBubbleSortResult(this)
            task.execute(10)

//            val inputValue: List<String> = et_input_array.toString().split(",")
//            //editText.text.toString()
//            if (inputValue == null || inputValue.isEmpty()) {
//                showToast(this, "cannot be left empty")
//
//            } else {
////                tv_sort_result.setText(inputValue).sort().toString()
//                showToast(this, inputValue.sorted().toString())
//                tv_sort_result.setText(inputValue.sorted().toString())
//            }

        }
    }

        companion object{

        class getBubbleSortResult internal constructor(context: SortingActivity):AsyncTask<Int,String,String?>(){

            private var resonse: String? = null
            private val activityRef:WeakReference<SortingActivity> = WeakReference(context)

            override fun onPreExecute() {
                val activity = activityRef.get()
                if(activity == null||activity.isFinishing)return
                activity.pb_array_calculation.visibility = View.VISIBLE
            }

            override fun onPostExecute(result: String?) {
                val activity = activityRef.get()
                if(activity == null||activity.isFinishing)return
                activity.pb_array_calculation.visibility=View.GONE
            }

            override fun doInBackground(vararg p0: Int?): String? {
                try {
                    Thread.sleep(5000)
//                    showToast(,"Calculating....")

                } catch (e: Exception) {
                    e.printStackTrace()
                    resonse = e.message
                }
                return resonse
            }

            override fun onProgressUpdate(vararg values: String?) {
                val activity = activityRef.get()
                if(activity == null || activity.isFinishing)return
            }

        }

        }


    }
