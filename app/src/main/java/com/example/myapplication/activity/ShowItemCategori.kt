package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.model.ModelShowItemCategori
import com.example.myapplication.presenter.presenterShowItemCategori
import com.example.myapplication.utility.Utility
import com.example.myapplication.view.ViewShowItemCategori

class ShowItemCategori : AppCompatActivity() , Utility{

    private lateinit var presenter : presenterShowItemCategori
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = ViewShowItemCategori(this , this)
        val model =  ModelShowItemCategori(this)
        setContentView(view)

        presenter = presenterShowItemCategori(view, model)
        presenter.oncreate()
    }


    override fun onfinished() {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.ondestroy()
    }
}