package com.candraibra.barvolume.ui.home

import CategoryResponse
import android.util.Log
import com.candraibra.barvolume.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoryPresenter(private val fragment: CategoryFragment) {

    fun getCategory() {
        val categoryCall = NetworkService().getApi().getExample()
        categoryCall.enqueue(object : Callback<CategoryResponse> {

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Log.d("Failure", t.message.toString())
            }

            override fun onResponse(
                call: Call<CategoryResponse>, response: Response<CategoryResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.category.isNotEmpty()) {
                            fragment.initAdapter(it.category)
                        }
                    }
                } else {
                    Log.d("response", "Response failed")
                }
            }

        })

    }

}