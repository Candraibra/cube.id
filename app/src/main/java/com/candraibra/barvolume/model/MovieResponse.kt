package com.candraibra.barvolume.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int,

    @field:SerializedName("results")
    val results: List<MovieItem> ,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)