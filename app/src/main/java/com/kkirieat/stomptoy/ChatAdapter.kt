package com.kkirieat.stomptoy

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_chat_from.view.*
import kotlinx.android.synthetic.main.row_chat_to.view.*
import java.lang.RuntimeException

class ChatAdapter(private val context: Context, private val chatList: ArrayList<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    // 보내는 메세지 클래스
    inner class SendHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val chat_Text = itemView?.to_msg_TextView
        val chat_Time = itemView?.to_time_TextView
    }

    // 받는 메세지 클래스
    inner class ReceiveHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val chat_Text = itemView?.from_msg_TextView
        val chat_Time = itemView?.from_time_TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        val v: View
        return when (viewType) {
            Message.RIGHT_TYPE -> {
                v = LayoutInflater.from(context).inflate(R.layout.row_chat_to, parent, false)
                SendHolder(v)
            }
            Message.LEFT_TYPE -> {
                v = LayoutInflater.from(context).inflate(R.layout.row_chat_from, parent, false)
                ReceiveHolder(v)
            }
            else -> throw RuntimeException("Unknown viewType ERROR")
        }

    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = chatList[position]
        when (chat.type) {
            Message.RIGHT_TYPE -> {
                (holder as SendHolder).chat_Text?.text = chat.message
                holder.chat_Time?.text = chat.time
            }
            Message.LEFT_TYPE -> {
                (holder as ReceiveHolder).chat_Text?.text = chat.message
                holder.chat_Time?.text = chat.time
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return chatList[position].type
    }



}