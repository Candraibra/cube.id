package com.candraibra.barvolume.ui.home


import Category
import Genres
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.candraibra.barvolume.databinding.FragmentCategoryBinding
import com.candraibra.barvolume.ui.home.adapter.CategoryAdapter


/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private lateinit var presenter: CategoryPresenter
    private lateinit var adapter: CategoryAdapter

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenter()
    }

    private fun initPresenter() {
        presenter = CategoryPresenter(this)
        presenter.getCategory()
    }

    fun initAdapter(list: List<Category>) {
        adapter = CategoryAdapter(list)
        binding.rvCategory.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

