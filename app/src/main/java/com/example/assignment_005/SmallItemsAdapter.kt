package com.example.assignment_005


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_005.databinding.BigItemBinding
import com.example.assignment_005.databinding.SmallItemBinding

class SmallItemsAdapter : RecyclerView.Adapter<SmallItemsAdapter.SmallItemsViewHolder>() {

    private val list = mutableListOf<Int>()
    fun setData(list: MutableList<Int>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallItemsViewHolder {
        return SmallItemsViewHolder(
            SmallItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SmallItemsViewHolder, position: Int) {

        holder.onBind()
    }

    override fun getItemCount() = list.size

    inner class SmallItemsViewHolder(private val binding: SmallItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
binding.et001.text = list[adapterPosition].toString()

        }

    }


}