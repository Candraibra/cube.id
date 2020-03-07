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
import com.candraibra.barvolume.ui.home.adapter.Adapterr
import com.candraibra.barvolume.ui.viewmodel.MovieViewModel
import com.candraibra.barvolume.utils.EndlessScrollListener
import kotlinx.android.synthetic.main.fragment_movie_tranding.*


/**
 * A simple [Fragment] subclass.
 */
class MovieTrendingFragment : Fragment() {
    private lateinit var viewModel: MovieViewModel

    private lateinit var adapter: Adapterr

    var movieList = mutableListOf<MovieItem>()

    private lateinit var scrollListener: EndlessScrollListener

    var page = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_tranding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        viewModel.init(page)
        adapter = Adapterr(movieList)
        initRv()

        viewModel.data.observe(viewLifecycleOwner, Observer {
            movieList.clear()
            movieList.addAll(it)
            adapter.hideLoading()
            adapter.notifyDataSetChanged()
        })
    }
//    viewModel.observeData(this, onGotData())
//    private fun onGotData(): Observer<MutableList<MovieItem>> = Observer {
//        movieList.clear()
//        movieList.addAll(it)
//        adapter.hideLoading()
//        adapter.notifyDataSetChanged()
//    }


    private fun initRv() {
        scrollListener = object : EndlessScrollListener() {
            override fun onLoadMore() {
                if (movieList.isNotEmpty()) {
                    page += 1
                    adapter.showLoading()
                    viewModel.getPopular(page)
                }
            }
        }
        rvTrendingMovie.addOnScrollListener(scrollListener)
        rvTrendingMovie.adapter = adapter
    }
}

