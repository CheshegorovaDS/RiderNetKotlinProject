package com.example.ridernetproject

import android.annotation.SuppressLint
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger.Messeger

import java.util.ArrayList

class MessegerAdapter(internal var list: ArrayList<Messeger>) :
    RecyclerView.Adapter<MessegerAdapter.TableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_message, parent, false)
        return TableViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        holder.nameUser.setText(list[position].fullName)
        holder.lastMessage.setText(list[position].messageText)
        holder.txtTime.setText(list[position].messageTime)
        if (list[position].unreadMessage === 0) {
            holder.txtUnreadMessage.visibility = View.INVISIBLE
        } else if (list[position].unreadMessage >= 100) {
            holder.txtUnreadMessage.text = "99+"
        } else {
            //holder.txtUnreadMessage.setText(list[position].unreadMessage + " ")
            holder.txtUnreadMessage.setText("${list[position].unreadMessage}")
        }
        holder.imgAvatarUser.setImageResource(R.drawable.ic_user)
    }

    inner class TableViewHolder @SuppressLint("WrongViewCast")
    constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var imgAvatarUser: ImageView
        internal var nameUser: TextView
        internal var lastMessage: TextView
        internal var txtTime: TextView
        internal var txtUnreadMessage: TextView


        init {
            this.imgAvatarUser = view.findViewById<View>(R.id.imgAvatarUser) as ImageView
            this.nameUser = view.findViewById<View>(R.id.txtNameUser) as TextView
            this.lastMessage = view.findViewById<View>(R.id.txtLastMessage) as TextView
            this.txtTime = view.findViewById<View>(R.id.txtTime) as TextView
            this.txtUnreadMessage = view.findViewById<View>(R.id.txtUnreadMessage) as TextView
        }

    }
}