package com.example.tae_kotlin_assessment_footy.common


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//for this example we are going to use the parent ViewGroup for the onCreateViewHolder
//@LayoutRes is specific to the ViewGroup
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    //logic comes here
    //replication of the ViewGroup as logic
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

////for the picasso i need constant + model[position].pathofimage -> into(holder.image)
//fun Picasso.get(@Path Constant : String ,position : Int  ,path:String){
//    return Picasso.onto(IMG_MOVIE + moviePopular.result[position].holder.image)
//}
//
//fun loadPic (Url:String? = "https://image.tmdb.org/t/p/w185"){
//    return loadPic(ImageView)
//}
////Picasso.get(loadPic).into(holder.image)

//THIS IS THE PROPER WAY TO EXTENSION FUNCTION FOR PICASSO
fun ImageView.loadImg(url: String) {
    Picasso.get().load(url).into(this)

}


fun <T> Call<T>.enqueue(callback: CallBackKt<T>.() -> Unit) {
    val callBackKt = CallBackKt<T>()
    callback.invoke(callBackKt)
    this.enqueue(callBackKt)
}

class CallBackKt<T> : Callback<T> {

    var onResponse: ((Response<T>) -> Unit)? = null
    var onFailure: ((t: Throwable?) -> Unit)? = null

    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure?.invoke(t)

    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        onResponse?.invoke(response)

    }

}

fun showToast(
    context: Context,
    text: String,
    duration: Int = Toast.LENGTH_SHORT
    /*functor: Toast.() -> Unit*/
) {
    val toast: Toast = Toast.makeText(context, text, duration)
    //toast.functor()
    toast.show()
}

fun ArrayList<Int>.sort(): ArrayList<Int> {
    var intervert = true
    while (intervert) {
        intervert = false
        for (i in 0 until this.indices.last) {
            if (this[i] > this[i + 1]) {
                val temp = this[i]
                this[i] = this[i + 1]
                this[i + 1] = temp

                intervert = true
            }
        }
    }
    return this
}



