package com.example.searchimage.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.searchimage.data.Photo
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //luu data cua viewHolder
    private var itemData: Photo? = null
    fun binData(photo: Photo) {
        itemData = photo
        itemView.run {
            Glide.with(this).load(itemData!!.userImageURL).into(imageViewPhoto)
        }
    }
}