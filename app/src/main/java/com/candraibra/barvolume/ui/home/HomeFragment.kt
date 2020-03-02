package com.candraibra.barvolume.ui.home


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.candraibra.barvolume.R
import com.candraibra.barvolume.ui.home.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    //    private lateinit var viewModel: MovieViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("onCreate", "koakd")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

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

//        viewModel.getData().observe(this, Observer { movie ->
//            rvCarousel.setHasFixedSize(true)
//            val adapter =
//                CarouselAdapter(
//                    activity!!.baseContext,
//                    movie.results
//                )
//            rvCarousel.adapter = adapter
//        })
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(activity!!.supportFragmentManager)
        adapter.addFragment(
            MovieTrendingFragment(),
            resources.getString(R.string.movie)
        )
        adapter.addFragment(
            TvTrendingFragment(),
            resources.getString(R.string.tv_show)
        )
        viewPager.adapter = adapter
    }
}
