package com.candraibra.barvolume.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.candraibra.barvolume.BuildConfig
import com.candraibra.barvolume.R
import com.candraibra.barvolume.model.MovieItem
import kotlinx.android.synthetic.main.layout_item_tranding.view.*
import java.text.SimpleDateFormat
import java.util.*

class TrendingAdapter(private val context: Context, private val movieList: List<MovieItem>) :
    RecyclerView.Adapter<TrendingAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item_tranding,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class Holder(val view: View) : RecyclerView.ViewHolder(view)

    fun getDate(date: String?): String {

        val convert = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return SimpleDateFormat(
            "dd.mm.yyyy",
            Locale.getDefault()
        ).format(convert.parse(date)?.time)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = movieList[position]
        Glide.with(context).asBitmap().load(BuildConfig.IMG_URL + data.posterPath)
            .into(holder.view.ivTrending)
        holder.view.tvTitleMovie.text = data.title

        holder.view.tvReleaseDate.text = getDate(data.releaseDate)

    }

}