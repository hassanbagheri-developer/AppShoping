package com.example.myapplication.net

import com.example.myapplication.dataClass.DataCategoriItem
import com.example.myapplication.dataClass.DataImgBannerUrl
import com.example.myapplication.dataClass.DataProduct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ApiService {

    interface DataApi {
        @GET("webservice/banner.json")
        fun getImgeUrlForBanner() : Call<DataImgBannerUrl>

        @GET("webservice/categorie.json")
        fun setDataRecycleCategory(): Call<List<DataCategoriItem>>

        @GET("webservice/new_products.json")
        fun getDataNewProducts(): Call<List<DataProduct>>

        @GET("webservice/new_products.json")
        fun getDataTakfifProducts(): Call<List<DataProduct>>

        @GET("webservice/new_products.json")
        fun getDataPorForoshProducts(): Call<List<DataProduct>>


    }

    fun getAPi() : DataApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://hasanlo.ir/android/shop/")
            .build()
            .create(DataApi::class.java)
}