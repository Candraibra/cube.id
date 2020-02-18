package com.candraibra.barvolume.network

import com.candraibra.barvolume.model.MovieItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/movie/{movie_id}")
    fun getMovieId(@Path("movie_id") movieId: String): Call<MovieItem>

}