package com.hunguet123.searchImage.ui.search

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.searchimage.R
import com.hunguet123.searchImage.base.BaseFragment
import com.hunguet123.searchImage.ui.favorite.FavoriteFragment
import com.hunguet123.searchImage.utils.Constant
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment(R.layout.fragment_search) {

    override fun initData() {
        //TODO("Not yet implemented")
    }

    override fun listenEvents() {
        imgButtonSearch.setOnClickListener {
            val resultFragment = Fragment()
            val bundle = Bundle()
            bundle.putString(Constant.ARGUMENT_SEARCH_KEY, textSearch.text.toString())
            resultFragment.arguments = bundle
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.frame_main, ResultSearchFragment())
                ?.addToBackStack(null)
                ?.commit()
        }

        buttonFavorite.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.frame_main, FavoriteFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
    }

    override fun observeData() {
        //TODO("Not yet implemented")
    }

    override fun setupViews() {
        //TODO("Not yet implemented")
    }
}
