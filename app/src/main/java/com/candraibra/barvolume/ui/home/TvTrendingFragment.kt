package com.candraibra.barvolume.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.candraibra.barvolume.R
import com.candraibra.barvolume.ui.home.adapter.TrendingAdapter
import com.candraibra.barvolume.ui.viewmodel.MovieViewModel
import com.candraibra.barvolume.ui.viewmodel.TvViewModel
import kotlinx.android.synthetic.main.fragment_movie_tranding.*
import kotlinx.android.synthetic.main.fragment_tv_tranding.*

/**
 * A simple [Fragment] subclass.
 */
class TvTrendingFragment : Fragment() {

    private lateinit var viewModel:TvViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_tranding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TvViewModel::class.java)

        viewModel.getData().observe(this, Observer { movie ->
            rvTrendingTv.setHasFixedSize(true)
            val adapter =
                TrendingAdapter(
                    activity!!.baseContext,
                    movie.results
                )
            rvTrendingTv.adapter = adapter
        })
    }


}
