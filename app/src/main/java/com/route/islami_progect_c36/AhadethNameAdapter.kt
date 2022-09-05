package com.route.islami_progect_c36

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AhadethNameAdapter (val listAhadeth : List<String>) : RecyclerView.Adapter<AhadethNameAdapter.ViewHolderAhadeth>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAhadeth {
        val viewAhadeth = LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name_ahadeth , parent , false)
            return ViewHolderAhadeth(viewAhadeth)
    }

    override fun onBindViewHolder(holder: ViewHolderAhadeth, position: Int) {
        holder.itemAhadethNAme.text = listAhadeth.get(position)
        holder.itemView.setOnClickListener {
            onAhadethClicked?.onItemClickListenerAhadeth(listAhadeth.get(position), position )
        }
    }
    var onAhadethClicked : OnItemClickListenerAhadeth? = null
    interface OnItemClickListenerAhadeth{
        fun onItemClickListenerAhadeth(hadethName : String , index: Int)
    }
    override fun getItemCount(): Int {
        return listAhadeth.size
    }
    class ViewHolderAhadeth (itemview : View): RecyclerView.ViewHolder(itemview){
        val itemAhadethNAme : TextView = itemview.findViewById(R.id.item_sura_name_title_ahadeth)

    }

}