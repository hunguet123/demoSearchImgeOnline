package com.hunguet123.searchImage.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.searchimage.R
import com.hunguet123.searchImage.data.model.Photo
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotosAdapter : ListAdapter<Photo, PhotosAdapter.PhotoViewHolder>(Photo.diffCallback){
    var onItemSelected : (Int, Photo) -> Unit = { _, _ ->}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(itemView, onItemSelected)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.binData(getItem(position))
    }

    class PhotoViewHolder(
        itemView: View,
        onItemSelected : (Int, Photo) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.checkboxFavorite.setOnCheckedChangeListener { _, isChecked ->
                itemData?.let {
                    it.favorite = isChecked
                    onItemSelected(adapterPosition, it)
                }
            }
        }

        private var itemData: Photo? = null

        fun binData(photo: Photo) {
            itemData = photo
            itemView.run {
                Glide.with(this)
                    .load(itemData?.url)
                    .into(imageViewPhoto)
                checkboxFavorite.isChecked = itemData?.favorite == true
            }
        }
    }
}
