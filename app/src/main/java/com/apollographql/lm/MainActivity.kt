package com.apollographql.lm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lastminute.kmp.data.create
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainScope().launch {
            val res = withContext(Dispatchers.IO){ create().fetchData() }
            content.text = res.toString()
        }

        btn.setOnClickListener {
            MainScope().launch {
                val res = withContext(Dispatchers.IO){ create().fetchData() }
                content.text = res.toString()
            }
        }
    }
}
