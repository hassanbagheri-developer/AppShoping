package com.example.myapplication.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.text.parseAsHtml
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activity.WebActivity
import com.example.myapplication.adpter.RecycleCategorieAdapter
import com.example.myapplication.dataClass.DataCategoriItem
import com.example.myapplication.dataClass.DataImgBannerUrl
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.enum.TypeGetProduct
import com.example.myapplication.model.ModelWebView
import com.example.myapplication.presenter.PresenterHomeFragment
import com.example.myapplication.utility.PicasoUtility
import com.example.myapplication.view.CustomView.ProductView
import kotlinx.android.synthetic.main.activity_more.*
import kotlinx.android.synthetic.main.fragment_home_.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val presenter: PresenterHomeFragment by inject()
    private val picasso: PicasoUtility by inject()
    private lateinit var img_baner1: AppCompatImageView
    private lateinit var recycle_categori: RecyclerView
    private lateinit var recycle_takhfif: ProductView
    private lateinit var recycle_porforosh: ProductView
    private lateinit var recycle_new: ProductView
    private lateinit var img_baner2: AppCompatImageView
    private lateinit var progeresbar: ProgressBar
    private lateinit var root: ConstraintLayout



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        img_baner1 = home_fragment_banner1
        img_baner2 = home_fragment_banner2
        recycle_categori = home_Fragment_recycle_categori
        recycle_takhfif = home_fragment_recycle_takhfif
        recycle_porforosh = home_fragment_recycle_porforosh
        recycle_new = home_fragment_recycle_new
        progeresbar = home_Fragment_progeresbar
        root = home_frament_root


        presenter.oncreate()

    }

    fun getDataRecycleProduct_new(data: List<DataProduct>) {
        recycle_new.initRecycler(data, TypeGetProduct.NEW_PRODUCT)
    }

    fun getDataRecycleProduct__takhfif(data: List<DataProduct>) {
        recycle_takhfif.initRecycler(data, TypeGetProduct.TAKHFIF_PRODUCT)
    }

    fun getDataRecycleProduct_porforosh(data: List<DataProduct>) {
        recycle_porforosh.initRecycler(data, TypeGetProduct.PORFOROSH_PRODUCT)
        hideProgress()
    }


    fun setDataRecycleCategory(data: List<DataCategoriItem>) {
        recycle_categori.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        recycle_categori.adapter = RecycleCategorieAdapter(context, data)
    }

    fun setImageInBannerr(data: DataImgBannerUrl) {
        picasso.setimage(data.image1, img_baner1)
        picasso.setimage(data.image2, img_baner2)

        img_baner1.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse(data.clickimage1)
//            startActivity(intent)

            context?.startActivity<WebActivity>(ModelWebView.KEY_URL to data.clickimage1)

        }

        img_baner2.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse(data.clickimage2)
//            startActivity(intent)
            context?.startActivity<WebActivity>(ModelWebView.KEY_URL to data.clickimage2)
        }
    }

    fun showToast(text: String) {
        context?.toast(text)
    }

    private fun showProgress() {
        progeresbar.visibility = View.VISIBLE
        root.visibility = View.INVISIBLE
    }

    private fun hideProgress() {
        progeresbar.visibility = View.INVISIBLE
        root.visibility = View.VISIBLE
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.ondestroy()
    }

}