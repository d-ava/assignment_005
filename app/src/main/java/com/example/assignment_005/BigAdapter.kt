package com.example.assignment_005

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_005.databinding.BigItemBinding

class BigItemsAdapter : RecyclerView.Adapter<BigItemsAdapter.BigItemsViewHolder>() {

    private val list = mutableListOf<Int>()
    fun setData(list: MutableList<Int>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BigItemsViewHolder {
        return BigItemsViewHolder(
            BigItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BigItemsViewHolder, position: Int) {

        holder.onBind()
    }

    override fun getItemCount() = list.size

    inner class BigItemsViewHolder(private val binding: BigItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
            binding.tvTitle.text = list[adapterPosition].toString()
            //binding.bigRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
            binding.bigRecyclerView.layoutManager = GridLayoutManager(itemView.context,1)
            val smallAdapter = SmallItemsAdapter()
            smallAdapter.setData(list)
            binding.bigRecyclerView.adapter = smallAdapter

        }

    }


}