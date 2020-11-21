package com.numabe.denchi.litboard_kanta

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_post.*

class postActivity : AppCompatActivity(){
    var database = FirebaseDatabase.getInstance()
    var refMeg = database.getReference("massage")
    var countMeg = database.getReference("countmsg")
    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        post.setOnClickListener {
            val message = messenge.text.toString()
            val userName = username.text.toString()
            val post = Post(userName, message, number)
            refMeg.push().setValue(post)
            countMeg.push().setValue(number)
            val intent = Intent(this, MainActivity::class.java)
            //intent.putExtra("number",number);
            startActivity(intent)
            finish()
        }

        number = 0

        //データの取得
        refMeg.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                number = dataSnapshot.childrenCount.toInt()
                /*for(int i = 0; i < dataSnapshot.getChildrenCount();i++){

                    number++;  //number = number + 1;
                }*/
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

//    fun onClick(v: View) {
//        val id = v.id
//        when (id) {
//            R.id.post -> {
//                val message = messenge.text.toString()
//                val userName = username.text.toString()
//                val post = Post(userName, message, number)
//                refMeg.push().setValue(post)
//                countMeg.push().setValue(number)
//                val intent = Intent(this, MainActivity::class.java)
//                //intent.putExtra("number",number);
//                startActivity(intent)
//                finish()
//            }
//        }
//    }
}






