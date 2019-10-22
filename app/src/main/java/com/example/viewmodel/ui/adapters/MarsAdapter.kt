package com.example.viewmodel.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel.R
import com.example.viewmodel.data.db.model.MarsItem
import com.example.viewmodel.data.db.model.WordItem
import com.example.viewmodel.databinding.ImageItemBinding
import com.squareup.picasso.Picasso

class MarsAdapter : ListAdapter<MarsItem, MarsAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<MarsItem>() {
        override fun areItemsTheSame(oldItem: MarsItem, newItem: MarsItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MarsItem, newItem: MarsItem): Boolean {
            return oldItem.id == newItem.id
        }
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder(private var binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: MarsItem) {
            binding.property = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view = ImageItemBinding.inflate(LayoutInflater.from(parent.context))

                return ViewHolder(view)
            }
        }
    }
}