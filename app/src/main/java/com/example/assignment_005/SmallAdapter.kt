package com.example.assignment_005

import android.annotation.SuppressLint
import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_005.databinding.SmallItemChooserBinding
import com.example.assignment_005.databinding.SmallItemInputBinding

object InpType {
    const val INPUT = 1
    const val CHOOSER = 2
}



class SmallAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: MutableList<Item.ItemSubList.ItemSubListItem> = mutableListOf()


    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Item.ItemSubList.ItemSubListItem>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].fieldType == FieldType.INPUT.type) {
            InpType.INPUT
        } else InpType.CHOOSER
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == InpType.INPUT) {
            return SmallInputTypeViewHolder(
                SmallItemInputBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            return SmallChooserTypeViewHolder(
                SmallItemChooserBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    //

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is SmallInputTypeViewHolder) {
            holder.onBind()
        } else if (holder is SmallChooserTypeViewHolder) {
            holder.onBind()
        }


    }

    override fun getItemCount() = list.size


    inner class SmallInputTypeViewHolder(private val binding: SmallItemInputBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var smallData: Item.ItemSubList.ItemSubListItem
        fun onBind() {
            smallData = list[adapterPosition]
            binding.et001.hint = smallData.hint
            binding.et001.isActivated = smallData.isActive!! //temporary
            binding.et001.setTag(R.string.id, smallData.fieldId)
            binding.et001.imeOptions = EditorInfo.IME_ACTION_DONE
            if (smallData.keyboard=="text"){
                binding.et001.inputType=InputType.TYPE_CLASS_TEXT
            }
            if (smallData.keyboard=="number"){
                binding.et001.inputType=InputType.TYPE_CLASS_NUMBER
            }
            binding.et001.isActivated = smallData.isActive == true




        }
    }

    inner class SmallChooserTypeViewHolder(private val binding: SmallItemChooserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var smallData: Item.ItemSubList.ItemSubListItem
        fun onBind() {
            smallData = list[adapterPosition]
            binding.et001.hint = smallData.hint
            binding.et001.isActivated = smallData.isActive!! //temporary
            binding.et001.setTag(R.string.id, smallData.fieldId)



        }

    }


}







