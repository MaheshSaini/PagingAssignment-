package com.backbase.assignment.ui.domain.repository

import com.backbase.assignment.ui.data.model.MovieList
import com.backbase.assignment.ui.data.model.MovieResult
import com.backbase.assignment.ui.data.model.movie.MovieDetails
import com.backbase.assignment.ui.network.MovieAppService
import com.backbase.assignment.ui.network.response.MovieListResponse


class Repository(private val service: MovieAppService) {

    suspend fun getPopularMovies(page: Int): MovieListResponse {
        return when (val result = service.fetchPopularMovies(page)) {
            is MovieResult.Success -> result.data
            is MovieResult.Error -> throw result.error
        }
    }

    suspend fun getMoviesPlayingNow(): MovieList {
        return when (val result = service.fetchPopularMoviesBanner()) {
            is MovieResult.Success -> result.data
            is MovieResult.Error -> throw result.error
        }
    }

    suspend fun fetchPopularMoviesDetails(movieID: String): MovieDetails {
        return when (val result = service.fetchPopularMoviesDetails(movieID)) {
            is MovieResult.Success -> result.data
            is MovieResult.Error -> throw result.error
        }
    }

}