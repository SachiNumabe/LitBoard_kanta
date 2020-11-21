package com.numabe.denchi.litboard_kanta

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_teni.*

class teniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teni)
        val intent = this.intent
        val text = intent.getStringExtra("scarlet")
        username.text = text
        val text2 = intent.getStringExtra("mafumafu")
        message.text = text2
    }

    fun back(v: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}