package com.hunguet123.searchImage.ui.search

import android.widget.Toast
import com.example.searchimage.R
import com.hunguet123.searchImage.base.BaseFragment
import com.hunguet123.searchImage.utils.Constant
import kotlinx.android.synthetic.main.fragment_result_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultSearchFragment : BaseFragment(R.layout.fragment_result_search) {
    private val viewModel : ResultSearchViewModel by viewModel()
    private val photosAdapter = PhotosAdapter()

    override fun setupViews() {
        recycleViewPhoto.adapter = photosAdapter
    }

    override fun listenEvents() {
        photosAdapter.onItemSelected = { _, itemData ->
            if (itemData.favorite) {
                viewModel.insertPhoto(itemData)
            } else {
                viewModel.deletePhotoFavorite(itemData.id)
            }
        }
    }

    override fun initData() {
        val bundle = this.arguments
        val q = bundle?.getString(Constant.ARGUMENT_SEARCH_KEY)
        viewModel.getImages(q)
    }

    override fun observeData() {
        viewModel.listImages.observe(viewLifecycleOwner) { listImages ->
            photosAdapter.submitList(listImages)
        }
        viewModel.error.observe(viewLifecycleOwner) { error->
            context?.run {
                Toast.makeText(this, error.message ?: "", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
