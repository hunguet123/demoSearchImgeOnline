package com.hunguet123.searchImage.ui.favorite

import android.widget.Toast
import com.example.searchimage.R
import com.hunguet123.searchImage.base.BaseFragment
import com.hunguet123.searchImage.ui.search.PhotosAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment(R.layout.fragment_favorite) {
    private val viewModel : FavoriteViewModel by viewModel()
    private val favoriteAdapter = PhotosAdapter()

    override fun listenEvents() {
        favoriteAdapter.onItemSelected = {position, itemData ->
            if (!itemData.favorite){
                viewModel.deletePhotoFavorite(itemData.id)
            }
        }
    }

    override fun setupViews() {
        recycleFavorite.adapter = favoriteAdapter
    }

    override fun observeData() {
        viewModel.photosFavorite.observe(viewLifecycleOwner) { listPhotoFavorite->
            println(listPhotoFavorite)
            favoriteAdapter.submitList(listPhotoFavorite)
            if (listPhotoFavorite.isEmpty()) {
                activity?.supportFragmentManager?.popBackStack()
            }
        }
        viewModel.error.observe(viewLifecycleOwner) { error ->
            context?.run {
                Toast.makeText(this, error.message ?: "", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun initData() {
        viewModel.getPhotosFavorite()
    }
}
