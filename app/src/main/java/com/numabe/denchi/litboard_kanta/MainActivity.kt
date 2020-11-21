package com.numabe.denchi.litboard_kanta

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_teni.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var regMsg: DatabaseReference = database.getReference("massage")

    var items: ArrayList<Post>? = null

    var randomNum = 0

    var count //要素数
            = 0


    var postAdapter: postAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        mButton.setOnClickListener(this);
//        mButton.setOnClickListener(this);
        count = 0
        randomNum = 0

        items = ArrayList()
        // items.add(new post("Res", "Pssoss"));
        // items.add(new post("Res", "Pssoss"));
        postAdapter = postAdapter(this, R.layout.listview_item_post, items!!)


        regMsg.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                Log.d("aaa","aa")
                val value = dataSnapshot.getValue()
                if(value != null){
                    println(value)
                    //items!!.add(value)
                }

                //  items.add(new post("a","b"));
                list_view!!.adapter = postAdapter

                /* postAdapter.clear();
                postAdapter.addAll(items);
                postAdapter.notifyDataSetChanged();
*/
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {}
            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {}
            override fun onCancelled(databaseError: DatabaseError) {}
        })


        //要素数


        //要素数
        regMsg.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                count = dataSnapshot.childrenCount.toInt()
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    fun back(v: View?) {
        val intent = Intent(this, postActivity::class.java)
        startActivity(intent)
    }

    fun pick(v: View?) {
        val random = Random()
        if (count != 0) randomNum = random.nextInt(count)
        regMsg.orderByChild("number").equalTo(randomNum.toDouble()).addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                val value: Post = dataSnapshot.getValue<Post>(Post::class.java)!!
                val intent = Intent(this@MainActivity, teniActivity::class.java)
                intent.putExtra("scarlet", value.userName)
                intent.putExtra("mafumafu", value.message)
                startActivity(intent)
                textView.text = value.userName
                textView2.text = value.message
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {}
            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {}
            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}

