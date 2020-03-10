package com.candraibra.barvolume.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.candraibra.barvolume.R
import com.candraibra.barvolume.model.MovieItem

class CarouselAdapter(private val context: Context, private val movieList: List<MovieItem>) :
    RecyclerView.Adapter<CarouselAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item_carousel, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class Holder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = movieList[position]
        //        Glide.with(context).asBitmap().load(BuildConfig.IMG_URL + data.posterPath)
        //            .into(holder.view.ivCarousel)
    }

}