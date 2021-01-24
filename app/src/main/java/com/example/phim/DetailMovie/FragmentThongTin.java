package com.example.phim.DetailMovie;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phim.DetailMovie.Detail.Actor;
import com.example.phim.DetailMovie.Detail.ActorAdapter;
import com.example.phim.DetailMovie.Detail.Dialog_trailer;
import com.example.phim.Dialog_loading;
import com.example.phim.Home.HomeFragment;
import com.example.phim.Home.Models.Movie;
import com.example.phim.Home.Models.Movie_Detail;
import com.example.phim.R;
import com.example.phim.Server.APIServer;
import com.example.phim.Server.DataServer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentThongTin extends Fragment {

    private View mRootView;
    ImageView imageView,img_trailer,img_background;
    TextView txtTitle, txtDetail, txtTheLoai,txt_gia,txt_dao_dien,txt_thoi_luong,txt_age_limit;
    RatingBar ratingBar;
    public  static  String linkTrailer,idMovie;
    Button btnMuaVe;
    RecyclerView re_actors;
    Dialog_loading dialog_loading;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView =inflater.inflate(R.layout.fragment_thongtin,container,false);
//
        dialog_loading = new Dialog_loading();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        dialog_loading.show(fragmentManager,"OK");


        AnhXa();

        img_trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                // Create and show the dialog.4
                Dialog_trailer newFragment = new Dialog_trailer ();
                newFragment.show(ft, "dialog");
            }
        });

        btnMuaVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),Setup_ticket.class);
//                startActivity(intent);
            }
        });


        return mRootView;
    }

    private void AnhXa() {

        Intent intent = new Intent();

        Movie thisMovie = new HomeFragment().selectedMovie;

        getMovieDetail(thisMovie.getId());

        img_background = (ImageView)mRootView.findViewById(R.id.img_hinh_hen);
        String url =getString(R.string.background_movie_detail_link) ;

        Picasso.with(getContext())
                .load(url)
                .error(R.drawable.ic_error_24)
                .placeholder(R.drawable.ic_download_24)
                .into(img_background);
        imageView =  mRootView.findViewById(R.id.movie_detail_img);
        Picasso.with(getContext())
                .load(thisMovie.getImage())
                .into(imageView);
        txtTitle = (TextView)  mRootView.findViewById(R.id.movie_detail_txt_title);
        txtTitle.setText(thisMovie.getName());
        txtDetail =  mRootView.findViewById(R.id.movie_detail_content);
        txtTheLoai = (TextView) mRootView.findViewById(R.id.txtTheLoai);
        txtTheLoai.setText(thisMovie.getTypeName());
        btnMuaVe = (Button)  mRootView.findViewById(R.id.btnMuaVe);
        img_trailer = (ImageView) mRootView.findViewById(R.id.movie_trailer_img);
        Picasso.with(getContext())
                .load(getString(R.string.link_icon_trailer))
                .error(R.drawable.ic_error_24)
                .placeholder(R.drawable.ic_download_24)
                .into(img_trailer);
        txt_gia = (TextView) mRootView.findViewById(R.id.gia_ban);
        txt_dao_dien = (TextView)mRootView.findViewById(R.id.dao_tien);
        re_actors = (RecyclerView)mRootView.findViewById(R.id.fragment_thong_tin_RecyclerView_list_actors);
        ratingBar = (RatingBar)mRootView.findViewById(R.id.ratingbar);
        txt_thoi_luong = (TextView)mRootView.findViewById(R.id.thoi_luong_phim);
        txt_age_limit = (TextView)mRootView.findViewById(R.id.movie_detail_age_limit);

    }
    public void getMovieDetail(String id) {
        DataServer dataServer = APIServer.getServer();
        loadActorList(id);
        Call<ArrayList<Movie_Detail>> callback = dataServer.getMovieDetail(id);
        callback.enqueue(new Callback<ArrayList<Movie_Detail>>() {
            @Override
            public void onResponse(Call<ArrayList<Movie_Detail>> call, Response<ArrayList<Movie_Detail>> response) {
                Movie_Detail result  = response.body().get(0);
                txt_dao_dien.setText(result.getDirector());
                btnMuaVe.setText(btnMuaVe.getText()+" "+result.getPrice()+getString(R.string.vnd));
                txtDetail.setText(result.getIntroduce());
                linkTrailer = result.getTrailer();
                ratingBar.setRating(Integer.parseInt(result.getRate()));
                txt_thoi_luong.setText(result.getLength());
                txt_age_limit.setText(result.getAgeLimit());
                dialog_loading.dismiss();
            }

            @Override
            public void onFailure(Call<ArrayList<Movie_Detail>> call, Throwable t) {
                Log.d("fff", "public void onFailure(Call<ArrayList<Movie_Detail>> call, Throwable t): "+t.getMessage());
            }
        });
    }
    public void loadActorList(String movieid) {


        DataServer dataServer = APIServer.getServer();
        Call<ArrayList<Actor>> callback = dataServer.getActor(movieid,1,1);
        callback.enqueue(new Callback<ArrayList<Actor>>() {
            @Override
            public void onResponse(Call<ArrayList<Actor>> call, Response<ArrayList<Actor>> response) {
                ActorAdapter actorAdapter = new ActorAdapter(getContext(),response.body());
                re_actors.setLayoutManager(new LinearLayoutManager(getActivity()));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                re_actors.setLayoutManager(linearLayoutManager);
                re_actors.setAdapter(actorAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Actor>> call, Throwable t) {

            }
        });


    }
}
