package com.candraibra.barvolume.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.candraibra.barvolume.BuildConfig
import com.candraibra.barvolume.R
import com.candraibra.barvolume.model.MovieItem
import kotlinx.android.synthetic.main.layout_carousel.view.*

class CarouselAdapter(private val context: Context, private val movieList: List<MovieItem>) : RecyclerView.Adapter<CarouselAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.layout_carousel, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class Holder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = movieList[position]
        Glide.with(context).asBitmap().load(BuildConfig.IMG_URL + data.posterPath)
            .into(holder.view.ivCarousel)
    }

}