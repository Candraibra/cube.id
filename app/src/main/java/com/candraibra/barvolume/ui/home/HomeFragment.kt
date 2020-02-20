package com.candraibra.barvolume.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.candraibra.barvolume.R
import com.candraibra.barvolume.ui.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

//        viewModel.getStatus().observe(this, Observer { t ->
//            if (t == false) {
//                tvTitleMovie.visibility = View.VISIBLE
//            } else {
//                tvTitleMovie.visibility = View.GONE
//            }
//
//        })
//
//        viewModel.setData().observe(this, Observer { t ->
//            tvTitleMovie.text = t.title.toString()
//
//        })

        viewModel.getData().observe(this, Observer { movie ->
            rvCarousel.setHasFixedSize(true)
            rvCarousel.addItemDecoration(DividerItemDecoration(activity, VERTICAL))
            val adapter = CarouselAdapter(activity!!.baseContext, movie.results)
            rvCarousel.adapter = adapter
        })

    }

}
