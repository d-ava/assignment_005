package com.example.assignment_005

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_005.databinding.BigItemBinding

class BigItemsAdapter : RecyclerView.Adapter<BigItemsAdapter.BigItemsViewHolder>() {



    //private val list = mutableListOf<Int>()
    var list:MutableList<List<Item.ItemSubList.ItemSubListItem>> = mutableListOf()
    //var list = mutableListOf<List<List<Item.ItemSubList.ItemSubListItem>>>()
    fun setData(list: List<List<Item.ItemSubList.ItemSubListItem>>) {
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

            binding.bigRecyclerView.layoutManager = LinearLayoutManager(itemView.context,RecyclerView.VERTICAL, false)

            val smallAdapter = SmallAdapter()

            smallAdapter.setData(list[adapterPosition])
            binding.bigRecyclerView.adapter = smallAdapter


        }

    }




}