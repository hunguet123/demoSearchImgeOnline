package com.example.searchimage.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.searchimage.R
import com.example.searchimage.recyclerView.adpater.PhotosAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModels()
    private val photoAdapter = PhotosAdapter()
    private val ApiKey = "30904452-89f11d979a176f8e7fa6ebda3"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textSearch = findViewById<EditText>(R.id.textSearch)
        val buttonSearch = findViewById<ImageButton>(R.id.imgButtonSearch)
        recycleViewPhoto.adapter = photoAdapter
        buttonSearch.setOnClickListener {
            recycleViewPhoto.isVisible = true
            viewModel.getPhotos(
                ApiKey,
                textSearch.text.toString(),
                "photo",
                onLoadDataSuccess = { responseJson ->
                    val listPhoto = responseJson.hits ?: emptyList()
                    println(listPhoto)
                    photoAdapter.submitList(listPhoto)
                    //Toast.makeText(this, "${listPhoto.size}", Toast.LENGTH_SHORT).show()
                    //photoAdapter.submitList(listPhoto)
                    //println(photoJsonList)
                    //photoAdapter.submitList(photoJsonList.toMutableList())
                },
                onLoadDataFailure = { throwable ->
                    Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
                    //println(throwable.message)
                }
            )
        }
    }
}