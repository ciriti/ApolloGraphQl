package com.apollographql.lm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lastminute.kmp.data.createRemoteRepoGraphQl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainScope().launch {
            val res = withContext(Dispatchers.IO){ createRemoteRepoGraphQl().fetchRepositories() }
            println("======================= BEGIN =========================")
            println(res)
            println("======================== END ========================")
        }

    }
}
