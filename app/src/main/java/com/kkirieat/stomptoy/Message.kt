package com.kkirieat.stomptoy

data class Message(val type: Int, val message: String, val time: String) {
    companion object{
        const val RIGHT_TYPE = 0  // 보내는 메세지
        const val LEFT_TYPE = 1   // 받는 메세지
    }
}