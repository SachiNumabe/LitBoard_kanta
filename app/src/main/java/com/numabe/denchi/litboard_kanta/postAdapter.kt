package com.numabe.denchi.litboard_kanta

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class postAdapter(
    conText: Context?,
    resource: Int,
    objects: List<Post>
) :
    ArrayAdapter<Post>(conText!!, resource, objects) {
    var items: List<Post>
    override fun getView(
        pposition: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val item: Post = getItem(pposition)
        val viewHelper: ViewHolder
        if (convertView != null) {
            viewHelper = convertView.tag as ViewHolder
        } else {
            convertView = LayoutInflater.from(context)
                .inflate(R.layout.listview_item_post, parent, false)
            viewHelper = ViewHolder()
            viewHelper.userNameText =
                convertView!!.findViewById<View>(R.id.username) as TextView
            viewHelper.messageText =
                convertView.findViewById<View>(R.id.messenge) as TextView
            convertView.tag = viewHelper
        }
        viewHelper.userNameText.setText(item.userName)
        viewHelper.messageText.setText(item.message)
        return convertView!!
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Post {
        return items[position]
    }

    internal class ViewHolder {
        var userNameText: TextView? = null
        var messageText: TextView? = null
    }

    init {
        items = objects
    }
}

private fun TextView?.setText(message: Any) {

}
