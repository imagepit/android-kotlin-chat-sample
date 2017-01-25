package com.imagepit.kotlinfirebasechat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class MessageListAdapter(private val context: Context, private val items: MutableList<Message>): BaseAdapter() {

    override fun getCount(): Int {
        return items.count()
    }

    override fun getItem(position: Int): Any {
        return items.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        // カスタムレイアウト読込
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        }
        // 各アイテムの表示設定
        val currentItem = getItem(position) as Message
        val messageTextView = convertView!!.findViewById(R.id.message) as TextView
        val dateTextView = convertView.findViewById(R.id.date) as TextView
        messageTextView.setText(currentItem.message)
        dateTextView.setText(currentItem.date.toString())
        return convertView
    }
}