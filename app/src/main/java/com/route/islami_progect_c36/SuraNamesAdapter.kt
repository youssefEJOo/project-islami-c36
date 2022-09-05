package com.route.islami_progect_c36

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SuraNamesAdapter (val list : List<String>): RecyclerView.Adapter<SuraNamesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name , parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.suraNameTextView.text = list.get(position)
        holder.itemView.setOnClickListener {
            onSuraNameClicked?.onItemClickListener(list.get(position) , position)
        }
    }
       var onSuraNameClicked : OnItemClickListener? = null
    interface OnItemClickListener{
        fun onItemClickListener(item : String , index : Int)

    }

    override fun getItemCount(): Int {
        return list.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val suraNameTextView : TextView = itemView.findViewById(R.id.item_sura_name_title)

    }
}


