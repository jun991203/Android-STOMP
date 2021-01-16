package com.kkirieat.stomptoy

data class Message(val message: String, val time: String, val type: Int) {
    companion object{
        const val RIGHT_TYPE = 0
        const val LEFT_TYPE = 1
    }
}