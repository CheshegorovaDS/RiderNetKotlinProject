package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger.model

import java.io.Serializable

class Messeger : Serializable {
    var fullName: String? = null
    var messageText: String? = null
    var messageTime: String? = null
    var unreadMessage: Int = 0

    constructor() { }

    constructor(fullName: String, messageText: String, messageTime: String, unreadMessage: Int) {
        this.fullName = fullName
        this.messageText = messageText
        this.messageTime = messageTime
        this.unreadMessage = unreadMessage
    }

    override fun toString(): String {
        return "Messeger{" +
                "fullName='" + fullName + '\''.toString() +
                ", messageText='" + messageText + '\''.toString() +
                ", messageTime='" + messageTime + '\''.toString() +
                ", unreadMessage=" + unreadMessage +
                '}'.toString()
    }

}