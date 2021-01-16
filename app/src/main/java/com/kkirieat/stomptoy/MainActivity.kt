package com.kkirieat.stomptoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var chattings = arrayListOf<Message>()
    val cAdapter = ChatAdapter(this, chattings)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Toolbar*/
        val toolbar = toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar!!
        actionBar.setDisplayShowTitleEnabled(false)

        /*Chatting RecyclerView*/
        chat_RecyclerView.adapter = cAdapter
        chat_RecyclerView.layoutManager = LinearLayoutManager(this)

        /*Send Message*/
        send_Button.setOnClickListener {
            sendMessage()
        }

    }

    /*보내는 메세지 추가하는 메소드*/
    fun sendMessage(){
        val currentDateTime = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA).format(currentDateTime)
        val timeString = dateFormat.toString()
        val time = timeString.slice(IntRange(11, 15))

        val message: String? = send_EditText.text.toString()
        // 작성된 메세지가 있는 경우에만 작동
        if (message != null){
            val chat = Message(Message.RIGHT_TYPE, message, time)
            cAdapter.addChat(chat)
            cAdapter.notifyDataSetChanged()
            // 채팅창 초기화
            send_EditText.setText("")
        }
    }

    /*받은 메세지 추가하는 메소드*/
    fun receiveMessage(){
        val currentDateTime = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA).format(currentDateTime)
        val timeString = dateFormat.toString()
        val time = timeString.slice(IntRange(11, 15))

        val message: String = ""    // 웹소켓으로 받은 메세지 넣기
        if (message != null){
            val chat = Message (Message.LEFT_TYPE, message, time)
            cAdapter.addChat(chat)
            cAdapter.notifyDataSetChanged()
        }
    }
}