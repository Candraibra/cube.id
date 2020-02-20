package com.candraibra.barvolume.network

import com.candraibra.barvolume.model.MovieItem
import com.candraibra.barvolume.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/{movie_id}")
    fun getMovieId(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String
    ): Call<MovieItem>

    @GET("movie/popular")
    fun getPopularMovie(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<MovieResponse>

}