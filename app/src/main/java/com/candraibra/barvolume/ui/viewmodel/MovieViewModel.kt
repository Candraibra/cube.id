package com.candraibra.barvolume.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.candraibra.barvolume.BuildConfig
import com.candraibra.barvolume.model.MovieResponse
import com.candraibra.barvolume.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    private var data = MutableLiveData<MovieResponse>()
//    private var status = MutableLiveData<Boolean>()

    init {
        getPopular()
    }

    //    private fun getData() {
//
//        status.value = true
//
//        NetworkService().getApi().getMovieId("111", BuildConfig.API_KEY)
//            .enqueue(object : Callback<MovieItem> {
//                override fun onFailure(call: Call<MovieItem>, t: Throwable) {
//                    status.value = true
//                    Log.d("movieViewModelFailure", t.toString())
//                }
//
//                override fun onResponse(call: Call<MovieItem>, response: Response<MovieItem>) {
//                    status.value = false
//
//                    if (response.isSuccessful) {
//                        data.value = response.body()
//                    } else {
//                        status.value = true
//                    }
//
//
//                }
//            })
//    }
//
//    fun setData(): MutableLiveData<MovieItem> {
//        return data
//    }
//
//    fun getStatus(): MutableLiveData<Boolean> {
//
//        status.value = true
//
//        return status
//
//
//    }
    private fun getPopular() {
        NetworkService().getApi().getPopularMovie(BuildConfig.API_KEY, 1)
            .enqueue(object : Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable?) {
                    Log.d("failure",t?.localizedMessage.toString())
                }

                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    if (response.isSuccessful){
                        data.postValue(response.body())
                    }
                }

            })
    }

        fun getData(): MutableLiveData<MovieResponse> {
        return data
    }
}