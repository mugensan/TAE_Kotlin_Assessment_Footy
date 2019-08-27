package com.example.tae_kotlin_assessment_footy.view

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tae_kotlin_assessment_footy.R
import com.example.tae_kotlin_assessment_footy.common.showToast
import kotlinx.android.synthetic.main.sorting_paradigm_layout.*
import java.lang.Exception
import java.lang.ref.WeakReference


class SortingActivity : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sorting_paradigm_layout)

        val inputValue = et_input_array.toString().split(",")
        val output = tv_sort_result


//        btn_sort.setOnClickListener {
//
//            showToast(this, "you clicked movie")
//            val list = arrayListOf(inputValue).sort()
//            for (i in 0 until list.size)
//                Log.d("array", list[i].toString())


//            startActivity(intent)

//        btn_sort.setOnClickListener {
//            //            val intent= Intent(this,
////                SortingActivity::class.java)
//            showToast(this, "You are sorting your array")
////            val sort = arrayListOf(inputValue)
////                .sort()
////            for(i in 0 until sort.size)
////
////                tv_sort_result = sort[i].toString())
////                Log.d("array", sort[i].toString())
//
//
////            startActivity(intent)
//
//            btn_sort.setOnClickListener() {
//
//                val task = (this)
//
//
//                val inputValue: List<String> = et_input_array.toString().split(",")
//                //editText.text.toString()
//                if (inputValue == null) {
//                    showToast(this, "cannot be left empty")
//
//                } else {
//
//                    var resultSort = arrayOf(output).sort().toString()
//                    resultSort = tv_sort_result.text.toString()
////                showToast(this, inputValue.sorted().toString())
////                tv_sort_result.setText(inputValue.sorted().toString())
//                }
//
//            }
//        }
//
//
//
//
//        companion object {
//
//            class GetBubbleSortResult internal constructor(context: SortingActivity) :
//                AsyncTask<Int, String, String?>() {
//
//                private var response: String? = null
//                private val activityRef: WeakReference<SortingActivity> = WeakReference(context)
//
//                override fun onPreExecute() {
//                    val activity = activityRef.get()
//                    if (activity == null || activity.isFinishing) return
//
//
//                    activity.pb_array_calculation.visibility = View.VISIBLE
//
//                }
//
//                override fun onPostExecute(result: String?) {
//                    val activity = activityRef.get()
//                    if (activity == null || activity.isFinishing) return
//                    activity.pb_array_calculation.visibility = View.GONE
//
//
//                }
//
//                override fun doInBackground(vararg p0: Int?): String? {
//
//
//                    try {
//                        Thread.sleep(5000)
//
//
//                    } catch (e: Exception) {
//                        e.printStackTrace()
//                        response = e.message
//                    }
//                    return response
//                }
//
//                override fun onProgressUpdate(vararg values: String?) {
//                    val activity = activityRef.get()
//                    if (activity == null || activity.isFinishing) return
//                }
//
//            }
//
//        }
//
//
//    }
//}
        }
    }
//}

