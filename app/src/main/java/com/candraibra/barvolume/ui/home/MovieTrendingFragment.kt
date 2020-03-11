package com.candraibra.barvolume.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.candraibra.barvolume.databinding.FragmentMovieTrandingBinding
import com.candraibra.barvolume.model.MovieItem
import com.candraibra.barvolume.ui.home.adapter.Adapterr
import com.candraibra.barvolume.ui.viewmodel.MovieViewModel
import com.candraibra.barvolume.utils.EndlessScrollListener


/**
 * A simple [Fragment] subclass.
 */
class MovieTrendingFragment : Fragment() {
    private lateinit var viewModel: MovieViewModel

    private lateinit var adapter: Adapterr

    var movieList = mutableListOf<MovieItem>()

    private lateinit var scrollListener: EndlessScrollListener

    private var _binding: FragmentMovieTrandingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var page = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMovieTrandingBinding.inflate(inflater, container, false)
        return binding.root
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
        binding.rvTrendingMovie.addOnScrollListener(scrollListener)
        binding.rvTrendingMovie.adapter = adapter
    }
}

