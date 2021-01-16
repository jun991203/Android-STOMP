package com.kkirieat.stomptoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Toolbar*/
        val toolbar = toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar!!
        actionBar.setDisplayShowTitleEnabled(false)

        /*Chatting RecyclerView*/
        var chattings = arrayListOf<Message>(
            Message("안녕!", "12:03", Message.RIGHT_TYPE),
            Message("반가워!", "12:04", Message.LEFT_TYPE)
        )

        val adapter = ChatAdapter(this, chattings)
        chat_RecyclerView.adapter = ChatAdapter(this, chattings)
        chat_RecyclerView.layoutManager = LinearLayoutManager(this)

    }
}