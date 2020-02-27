package com.candraibra.barvolume.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.candraibra.barvolume.R
import com.candraibra.barvolume.model.MovieItem
import com.candraibra.barvolume.ui.home.adapter.TrendingAdapter
import com.candraibra.barvolume.ui.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie_tranding.*

/**
 * A simple [Fragment] subclass.
 */
class MovieTrendingFragment : Fragment() {
    private lateinit var viewModel: MovieViewModel

    var movieList: List<MovieItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_tranding, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        viewModel.getData().observe(viewLifecycleOwner, Observer { movie ->
            movieList = movie.results
            val adapter =
                TrendingAdapter(
                    activity!!.baseContext,
                    movieList
                )
            rvTrendingMovie.adapter = adapter
        })
    }
}
