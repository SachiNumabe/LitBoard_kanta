package com.numabe.denchi.litboard_kanta

import kotlinx.android.synthetic.main.activity_teni.*

class Post {
    var message: String = ""
    var userName: String = ""
    var number = 0

    constructor(userName: String, message: String, number: Int) {
        this.userName = userName
        this.message = message
        this.number = number
    }

    constructor() {}

    fun message(): String {
        return message
    }

    fun userName(): String {
        return userName
    }


}