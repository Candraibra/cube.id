package com.candraibra.barvolume.ui.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.candraibra.barvolume.BuildConfig
import com.candraibra.barvolume.databinding.LayoutItemTrandingBinding
import com.candraibra.barvolume.model.MovieItem
import com.candraibra.barvolume.ui.practice.HomeActivity
import com.candraibra.barvolume.utils.BaseAdapter

class Adapterr(private var movieList: List<MovieItem>) : BaseAdapter() {

    override fun onCreateNormalViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return NormalViewHolder(
            LayoutItemTrandingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getDataSize(): Int {
        return movieList.size
    }

    override fun onBindNormalViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = movieList[position]
        (holder as NormalViewHolder).bind(data)
    }

    class NormalViewHolder(val view: LayoutItemTrandingBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(movieItem: MovieItem) {
            Glide.with(view.root.context).asBitmap()
                .load(BuildConfig.IMG_URL + movieItem.posterPath)
                .into(view.ivTrending)

            view.tvTitleMovie.text = movieItem.title

            view.tvReleaseDate.text = movieItem.releaseDate

            view.root.setOnClickListener() {
                val intent = Intent(itemView.context, HomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra(HomeActivity.EXTRA_TITLE, movieItem.title)
                view.root.context.startActivity(intent)
            }
        }
    }
}