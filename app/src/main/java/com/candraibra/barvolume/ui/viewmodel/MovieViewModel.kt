package com.candraibra.barvolume.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.candraibra.barvolume.BuildConfig
import com.candraibra.barvolume.model.MovieItem
import com.candraibra.barvolume.network.NetworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import androidx.lifecycle.MutableLiveData as MLiveData


class MovieViewModel : ViewModel() {

    private var data = MLiveData<MutableList<MovieItem>>(mutableListOf())
    var isInitialized = false

    fun init(page: Int) {
        if (!isInitialized) {
            isInitialized = true
            getPopular(page)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("onCleared", data.value.toString())
    }

    fun getPopular(page: Int) {
        val compositeDisposable = CompositeDisposable()
        val api = NetworkService().getApi().getPopularMovie(BuildConfig.API_KEY, page)
        api.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data.postValue(data.value?.apply { addAll(it.results) })
            }, {
                val code = (it as HttpException).code()
                if (code == 404) {
                    Log.d("dhaia", it.toString())
                    Log.d("dhaia", code.toString())
                }
            }).let(compositeDisposable::add)
    }

    fun getData(): MLiveData<MutableList<MovieItem>> {
        return data
    }
}