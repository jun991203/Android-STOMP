package com.kkirieat.stomptoy

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_chat_from.view.*
import kotlinx.android.synthetic.main.row_chat_to.view.*

class ChatAdapter(private val context: Context, private val msgList: ArrayList<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


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

        if(viewType == 1) {
            // 상대방에게 메세지를 보내는 경우
            v = LayoutInflater.from(context).inflate(R.layout.row_chat_to, parent, false)
            return SendHolder(v)
        }
        else{
            // 상대방에게 메세지를 받는 경우
            v = LayoutInflater.from(context).inflate(R.layout.row_chat_from, parent, false)
            return ReceiveHolder(v)
        }

    }

    override fun getItemCount(): Int {
        return msgList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is SendHolder){
            holder.chat_Text?.text = msgList[position].message
            holder.chat_Time?.text = msgList[position].time
        }else if(holder is ReceiveHolder){
            holder.chat_Text?.text = msgList[position].message
            holder.chat_Time?.text = msgList[position].time
        }
    }



}