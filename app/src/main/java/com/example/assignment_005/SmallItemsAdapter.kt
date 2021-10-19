package com.example.assignment_005


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_005.databinding.BigItemBinding
import com.example.assignment_005.databinding.SmallItemBinding

object InputType {
    const val INPUT = 1
    const val CHOOSER = 2
}


class SmallItemsAdapter : RecyclerView.Adapter<SmallItemsAdapter.SmallItemsViewHolder>() {

    var list: MutableList<Item.ItemSubList.ItemSubListItem> = mutableListOf()

    //private val list = mutableListOf<Int>()
    fun setData(list: List<Item.ItemSubList.ItemSubListItem>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

   /* override fun getItemViewType(position: Int): Int {
        return if (list[position].fieldType == FieldType.INPUT.type) {
            InputType.INPUT
        } else InputType.CHOOSER
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallItemsViewHolder {
        return SmallItemsViewHolder(
            SmallItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        /*    when (viewType) {
                InputType.INPUT -> SmallInputTypeViewHolder(
                    SmallItemBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false
                    )
                )
                else -> SmallChooserTypeViewHolder(
                    SmallItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

          */

    }

    override fun onBindViewHolder(holder: SmallItemsViewHolder, position: Int) {

        holder.onBind()
    }

    override fun getItemCount() = list.size


    /*   inner class SmallInputTypeViewHolder(private val binding: SmallItemBinding) :
           RecyclerView.ViewHolder(binding.root) {

       }

       inner class SmallChooserTypeViewHolder(private val binding: SmallItemBinding) :
           RecyclerView.ViewHolder(binding.root) {

       }*/

    inner class SmallItemsViewHolder(private val binding: SmallItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var smallData: Item.ItemSubList.ItemSubListItem

        fun onBind() {
            smallData = list[adapterPosition]
            binding.et001.text = smallData.hint.toString()
        }

    }




}