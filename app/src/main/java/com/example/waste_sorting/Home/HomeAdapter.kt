package com.example.waste_sorting

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.waste_sorting.Home.HomeDetailActivity
import kotlinx.android.synthetic.main.activity_homedetail.view.*
import kotlinx.android.synthetic.main.home_item.view.*

data class HomeData( var img:Int, var title:String, var detail_img:Int,
                     var detail_text1:String, var detail_center_img:Int, var detail_text2:String)

class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val img: ImageView = v.home_img
    val title: TextView = v.home_title
    var detail_img: ImageView? = v.detail_img
    var detail_text1: TextView? = v.detail_text1
    var detail_center_img: ImageView? = v.detail_center_img
    var detail_text2: TextView? = v.detail_text2
}

class HomeAdapter(val DataList: ArrayList<HomeData>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val Data = DataList[position]

        holder.img.setImageResource(Data.img)
        holder.title.text = Data.title
        holder.detail_img?.setImageResource(Data.detail_img)
        holder.detail_text1?.text = Data.detail_text1
        holder.detail_center_img?.setImageResource(Data.detail_center_img)
        holder.detail_text2?.text = Data.detail_text2

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, HomeDetailActivity::class.java)

            intent.putExtra("detail_img", Data.detail_img)
            intent.putExtra("title", Data.title)
            intent.putExtra("detail_text1", Data.detail_text1)
            intent.putExtra("detail_center_img", Data.detail_center_img)
            intent.putExtra("detail_text2", Data.detail_text2)

            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount() = DataList.size
}