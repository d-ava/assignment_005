package com.example.assignment_005


import com.google.gson.annotations.SerializedName

class Item : ArrayList<Item.ItemSubList>(){
    class ItemSubList : ArrayList<ItemSubList.ItemSubListItem>(){
        data class ItemSubListItem(
            @SerializedName("field_id")
            val fieldId: Int?,
            val hint: String?,
            @SerializedName("field_type")
            val fieldType: String?,
            val keyboard: String?,
            val required: String?,
            @SerializedName("is_active")
            val isActive: Boolean?,
            val icon: String?
        )
    }
}