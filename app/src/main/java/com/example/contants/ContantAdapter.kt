package com.example.contants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ContantAdapter(val items: ArrayList<ContantModel>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
       return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView: View
        var viewHolder: ViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.contant_item, parent, false)
            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = itemView.tag as ViewHolder
        }

        viewHolder.name.text = items[position].name
        viewHolder.avatar.setImageResource(items[position].avatar)
        return itemView
    }

    class ViewHolder(itemView: View){
        val name: TextView
        val avatar: ImageView

        init {
            avatar = itemView.findViewById(R.id.avatarImageView)
            name = itemView.findViewById(R.id.nameTextView)
        }
    }
}