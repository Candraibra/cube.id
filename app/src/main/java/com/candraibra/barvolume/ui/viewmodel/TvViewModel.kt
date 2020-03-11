package com.candraibra.barvolume.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.candraibra.barvolume.BuildConfig
import com.candraibra.barvolume.model.MovieResponse
import com.candraibra.barvolume.network.NetworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import androidx.lifecycle.MutableLiveData as MLiveData


class TvViewModel : ViewModel() {
    private var data = MLiveData<MovieResponse>()

    init {
        getPopular()
    }

    @Throws(Exception::class)
    private fun getPopular() {
        val compositeDisposable = CompositeDisposable()
        NetworkService().getApi().getPopularTv(BuildConfig.API_KEY, 1).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                data.postValue(it)
            }, {
                val code = (it as HttpException).code()
                Log.d("dhaia", it.toString())
                Log.d("dhaia", code.toString())

            }).let(compositeDisposable::add)
        throw Exception()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("cleared", "onCleared().toString()")
    }

    fun getData(): MLiveData<MovieResponse> {
        return data
    }
}