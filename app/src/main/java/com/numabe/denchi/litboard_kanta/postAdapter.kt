package com.numabe.denchi.litboard_kanta

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class postAdapter(
     private val context: Context?
) :RecyclerView.Adapter<postAdapter.ViewHolder>() {
    var items: MutableList<Post> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.listview_item_post,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.messageText.text = item.message
        holder.userNameText.text = item.userName
    }

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        var userNameText: TextView = view.findViewById(R.id.username)
        var messageText: TextView = view.findViewById(R.id.messenge)
    }

    fun addAll(itemList: List<Post>){
        items.addAll(itemList)
        notifyDataSetChanged()
    }

}

