package com.imagepit.kotlinfirebasechat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 送信ボタンクリックイベント登録
        sendButton.setOnClickListener { onClick() }

        // FirebaseDBのリアルタイム同期開始
        FirebaseDBHelper.fetchMessages(
                {list -> listView.adapter = MessageListAdapter(this,list)},
                {e -> Log.d("debug","データ取得エラー:" + e)}
        )
    }

    // 送信ボタンクリック時
    fun onClick() {
        val msg = Message(textField.text.toString(), Date(System.currentTimeMillis()))
        FirebaseDBHelper.addMessage(msg, { e -> Log.d("debug","データ登録エラー" + e)})
        textField.setText("")
    }
}
