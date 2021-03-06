package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adpter.RecycleItemMoreAdapter
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.enum.TypeGetProduct
import com.example.myapplication.utility.Utility
import kotlinx.android.synthetic.main.activity_more.view.*
import org.jetbrains.anko.toast

@SuppressLint("ViewConstructor")
class ViewMoreActivity (contextInstance : Context, private val utility: Utility) : FrameLayout(contextInstance) {

    private val txtTitle : AppCompatTextView
    private val imgBack : AppCompatImageView
    private val recycleview :RecyclerView

    init {
        val mainView = inflate(context,R.layout.activity_more,this)


        txtTitle = mainView.show_item_categori_title
        imgBack  = mainView.question_imgBack
        recycleview = mainView.more_recycleview

        recycleview.layoutManager = GridLayoutManager(context,2,LinearLayoutManager.VERTICAL , false)
    }

    fun getDataRecycleProductMoreActivity(data : List<DataProduct>){
        recycleview.adapter = RecycleItemMoreAdapter(context,data)
        recycleview.visibility= View.VISIBLE
        more_progressBar.visibility = View.INVISIBLE
    }


    fun setTitleText(title:String){
        txtTitle.text = title
    }

    fun showToast(text : String){
        context.toast(text)
    }

    fun settypeproduct(type : TypeGetProduct){
        when(type){
            TypeGetProduct.TAKHFIF_PRODUCT -> context?.toast("takhfif")
            TypeGetProduct.NEW_PRODUCT -> context?.toast("new")
            else -> context?.toast("porforosh")

        }
    }


    fun onClickHandler(){
        imgBack.setOnClickListener{ utility.onfinished()}
    }

}