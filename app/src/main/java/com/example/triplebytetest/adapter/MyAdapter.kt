package com.example.triplebytetest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplebytetest.R
import com.example.triplebytetest.model.TripleByteTransaction
import kotlinx.android.synthetic.main.header.view.*
import kotlinx.android.synthetic.main.item_layout.view.*

class MyAdapter constructor(val list: List<TripleByteTransaction>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val VIEW_TYPE_HEADER = 0
    val VIEW_TYPE_ITEM = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if(viewType == VIEW_TYPE_HEADER){
            return MyViewHolderHeader(LayoutInflater.from(parent.context).inflate(R.layout.header,parent, false))

        } else {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent, false))
            }
    }


    override fun getItemViewType(position: Int): Int {
        return if (list[position].header) {
            VIEW_TYPE_HEADER

        } else {
            VIEW_TYPE_ITEM
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(holder is MyViewHolder) {
            holder.bind(list[position])
        } else  if(holder is MyViewHolderHeader){

            holder.bind(list[position])
        }
    }


    class MyViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){


        val title = itemView.title
        val date = itemView.date
        val price = itemView.price

        fun bind(data: TripleByteTransaction){

            title.text = data.title
            date.text = data.date
            price.text = data.price


        }
    }

    class MyViewHolderHeader constructor(itemView: View): RecyclerView.ViewHolder(itemView){


        val header = itemView.header


        fun bind(data: TripleByteTransaction){

            header.text = "FOOD"


        }
    }

}
