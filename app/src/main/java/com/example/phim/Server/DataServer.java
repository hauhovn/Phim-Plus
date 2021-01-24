package com.example.phim.Server;

import com.example.phim.DetailMovie.Detail.Actor;
import com.example.phim.Home.Models.Movie;
import com.example.phim.Home.Models.Movie_Detail;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DataServer {

    @POST("movie/get-list-movie.php")
    @FormUrlEncoded
    Call<ArrayList<Movie>> getMovie(
        @Field("quantity") int quantity,
        @Field("status") int status
    );

    @POST("movie/get-movie-detail.php")
    @FormUrlEncoded
    Call<ArrayList<Movie_Detail>> getMovieDetail(
            @Field("movie_id") String Id
    );

    //ACTOR

    @POST("actor/get-list-actor.php")
    @FormUrlEncoded
    Call<ArrayList<Actor>> getActor(
            @Field("movie-id") String movie_id,
            @Field("quantity") int quantity,
            @Field("status") int status
    );

}
