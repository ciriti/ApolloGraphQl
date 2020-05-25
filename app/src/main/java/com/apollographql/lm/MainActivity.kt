package com.apollographql.lm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lastminute.kmp.data.createRemoteRepoGraphQl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            MainScope().launch {
                val res = withContext(Dispatchers.IO){ createRemoteRepoGraphQl().fetchUser("1") }
                println("======================= BEGIN =========================")
                Toast.makeText(this@MainActivity, res.toString(), Toast.LENGTH_SHORT).show()
                println(res)
                println("======================== END ========================")
            }
        }

    }
}
