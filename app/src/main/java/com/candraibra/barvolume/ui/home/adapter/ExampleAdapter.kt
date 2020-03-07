package com.candraibra.barvolume.ui.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.candraibra.barvolume.BuildConfig
import com.candraibra.barvolume.R
import com.candraibra.barvolume.model.MovieItem
import com.candraibra.barvolume.ui.practice.HomeActivity
import kotlinx.android.synthetic.main.layout_item_tranding.view.*

class ExampleAdapter(private val context: Context, private var movieList: List<MovieItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_LOADING = 90
        private const val VIEW_TYPE_NORMAL = 190
    }

    private var mShowLoading = false

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_NORMAL -> NormalViewHolder(
                inflater.inflate(
                    R.layout.layout_item_tranding,
                    null
                )
            )
            else -> LoadingViewHolder(inflater.inflate(R.layout.layout_loading_horizontal, null))
        }
    }


    override fun getItemCount(): Int {
        return movieList.size + if (mShowLoading) { 1
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NormalViewHolder) {
            val data = movieList[position]

            Glide.with(context).asBitmap().load(BuildConfig.IMG_URL + data.posterPath)
                .into(holder.itemView.ivTrending)
            holder.itemView.tvTitleMovie.text = data.title

            holder.itemView.tvReleaseDate.text = data.releaseDate

            holder.itemView.setOnClickListener() {
                val intent = Intent(holder.itemView.context, HomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra(HomeActivity.EXTRA_TITLE, data.title)
                context.startActivity(intent)
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position < movieList.size) {
            return VIEW_TYPE_NORMAL
        }
        return VIEW_TYPE_LOADING
    }


    class LoadingViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class NormalViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
