package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.messeger

import java.io.Serializable
import java.util.*

class Messeger : Serializable {
    var fullName: String? = null
    var messageText: String? = null
    var messageTime: String? = null
    var unreadMessage: Int = 0

    constructor() {
        //unreadMessage = 0;
    }

    constructor(fullName: String, messageText: String, messageTime: String, unreadMessage: Int) {
        this.fullName = fullName
        this.messageText = messageText
        this.messageTime = messageTime
        this.unreadMessage = unreadMessage
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val messeger = o as Messeger?
        return unreadMessage == messeger!!.unreadMessage &&
                fullName == messeger.fullName &&
                messageText == messeger.messageText &&
                messageTime == messeger.messageTime
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