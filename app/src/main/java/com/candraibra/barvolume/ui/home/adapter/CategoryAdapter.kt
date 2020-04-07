package com.candraibra.barvolume.ui.home.adapter

import Category
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.candraibra.barvolume.R
import com.candraibra.barvolume.databinding.LayoutButtonLoadMoreBinding
import com.candraibra.barvolume.databinding.LayoutItemCategoryBinding

class CategoryAdapter(private val list: List<Category>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_LIST -> NormalViewHolder(
                LayoutItemCategoryBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            VIEW_ADD_BUTTON -> ButtonViewHolder(
                LayoutButtonLoadMoreBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> throw IllegalArgumentException("unknown view type $viewType")
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            VIEW_TYPE_LIST -> (holder as NormalViewHolder).bind(list[position])
            VIEW_ADD_BUTTON -> (holder as ButtonViewHolder).bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            list.size -> VIEW_ADD_BUTTON
            else -> VIEW_TYPE_LIST
        }
    }

    class NormalViewHolder(val view: LayoutItemCategoryBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(data: Category) {
            Glide.with(view.root).load(data.image).into(view.ivCategory)
            view.tvCategory.text = data.name
            view.root.setOnClickListener {
                val navController = Navigation.findNavController(
                    (view.root.context) as Activity,
                    R.id.nav_host_home
                )
                navController.navigate(R.id.action_movieFragment2_to_settingsFragment2)
            }
        }
    }

    class ButtonViewHolder(val view: LayoutButtonLoadMoreBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind() {
            view.btnCategory.setOnClickListener {

            }
        }
    }

    companion object {
        private const val VIEW_TYPE_LIST = 666
        private const val VIEW_ADD_BUTTON = 999
    }

}