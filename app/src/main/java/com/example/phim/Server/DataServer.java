package com.example.phim.Server;

import com.example.phim.Home.Models.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DataServer {

    @POST("movie/get-movie.php")
    @FormUrlEncoded
    Call<ArrayList<Movie>> getMovie(
        @Field("quantity") int quantity,
        @Field("status") int status
    );

    @POST("movie/get-movie-detail.php")
    @FormUrlEncoded
    Call<ArrayList<Movie>> getMovieDetail(
            @Field("id") int Id
    );

}
