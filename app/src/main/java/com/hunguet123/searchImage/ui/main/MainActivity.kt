package com.hunguet123.searchImage.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.searchimage.R
import com.hunguet123.searchImage.ui.search.SearchFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_main, SearchFragment())
            .commit()

    }
}
