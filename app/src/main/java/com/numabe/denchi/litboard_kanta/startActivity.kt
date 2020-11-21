package com.numabe.denchi.litboard_kanta

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class startActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

    fun button(v: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}