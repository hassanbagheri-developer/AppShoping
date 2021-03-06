package com.example.myapplication.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activity.ShowItemCategori
import com.example.myapplication.dataClass.DataCategoriItem
import kotlinx.android.synthetic.main.item_recycler_categorie_view.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RecycleCategorieAdapter(
    private val context: Context?,
    private val data: List<DataCategoriItem>
) : RecyclerView.Adapter<RecycleCategorieAdapter.CategoryViewHolder>() {

    companion object {

        const val KEY_ID = "id"
        const val KEY_TITLE = "id"

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler_categorie_view, parent, false)
        )

    override fun getItemCount() = data.size


    inner class CategoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val textTitle = item.recyclerView_categori_txt

        fun setDAta(data: DataCategoriItem) {
            textTitle.text = data.title
            textTitle.setOnClickListener {
                context?.startActivity<ShowItemCategori>(
                    KEY_ID to data.id,
                    KEY_TITLE to data.title
                )
            }
        }
    }


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.setDAta(data[position])
    }
}