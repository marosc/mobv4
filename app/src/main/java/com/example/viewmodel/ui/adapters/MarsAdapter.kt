package com.example.viewmodel.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel.R
import com.example.viewmodel.data.db.model.MarsItem
import com.example.viewmodel.data.db.model.WordItem
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class MarsAdapter : RecyclerView.Adapter<MarsAdapter.ViewHolder>() {

    var data = listOf<MarsItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mars_image: ImageView = itemView.findViewById(R.id.mars_image)
        val mars_type: TextView = itemView.findViewById(R.id.mars_type)
        val mars_price: TextView = itemView.findViewById(R.id.mars_price)

        fun bind(item: MarsItem) {
            Picasso.get().load(item.img_src).into(mars_image)
            mars_type.text = item.type
            mars_price.text = "$ ${item.price}"
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.mars_item, parent, false)

                return ViewHolder(view)
            }
        }
    }
}