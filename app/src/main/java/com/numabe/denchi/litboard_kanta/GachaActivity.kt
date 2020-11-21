package com.numabe.denchi.litboard_kanta

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class GachaActivity : AppCompatActivity() {
    var mafuteru: TextView? = null
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mafuteru = findViewById<View>(R.id.mafuteru) as TextView
        count = 0
    }

    fun add(v: View?) {
        count += 1
        val randomName = Random()
        val index = randomName.nextInt(51)
        mafuteru!!.text = index.toString() + "回ボタンが押されますた。"
    }
}