package com.example.phim.Home;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ViewFlipper;

import com.example.phim.Constant;
import com.example.phim.DetailActivity;
import com.example.phim.Dialog_loading;
import com.example.phim.Home.Adapter.MovieAdapter;
import com.example.phim.Home.Models.Movie;
import com.example.phim.R;
import com.example.phim.SaveData;
import com.example.phim.Server.APIServer;
import com.example.phim.Server.DataServer;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements MovieAdapter.OnMovieListener{

    //Views
    RecyclerView mRecyclerView_DangChieu, mRecyclerView_SapChieu;
    Button mButton_showDangChieu, mButton_showSapChieu;
    ViewFlipper mViewFlipper_LiveShow;
    View mRootView;
    public static Movie selectedMovie = new Movie();
    Dialog_loading dialog_loading;
    //Data
    //KEYs
    private ArrayList<Movie> mListMovie = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView =  inflater.inflate(R.layout.fragment_home, container, false);
        //
        showLoading();
        //
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                //TODO cancel back button in here!
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
        //Init
        init(mRootView);

        getMovieList(1,2,mRecyclerView_SapChieu);
        getMovieList(1,2,mRecyclerView_DangChieu);
        //


        return mRootView;
    }

    private void init(View view) {
        mRecyclerView_DangChieu =(RecyclerView) view.findViewById(R.id.RvPhimDangChieu);
        mRecyclerView_SapChieu =(RecyclerView) view.findViewById(R.id.RvPhimSapChieu);
        mButton_showDangChieu =(Button) view.findViewById(R.id.btnPhimDangChieu);
        mButton_showSapChieu =(Button) view.findViewById(R.id.btnPhimSapChieu);
        mViewFlipper_LiveShow = (ViewFlipper) view.findViewById(R.id.slideShow);
    }

    private void loadRecylerviewMovie(RecyclerView recyclerView, ArrayList<Movie> movieList) {
        MovieAdapter adapter = new MovieAdapter(getContext(),mListMovie,this);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void getMovieList(int status, int quantity, RecyclerView mRecyclerView) {
        DataServer dataServer = APIServer.getServer();
        Call<ArrayList<Movie>> callback = dataServer.getMovie(quantity,status);
        callback.enqueue(new Callback<ArrayList<Movie>>() {
            @Override
            public void onResponse(Call<ArrayList<Movie>> call, Response<ArrayList<Movie>> response) {
                Log.d("fff", "list movie size: "+response.body().size());
                MovieAdapter adapter = new MovieAdapter(getContext(),response.body(),HomeFragment.this);
                // Set layout manager to position the items
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(linearLayoutManager);
                mRecyclerView.setAdapter(adapter);
                dialog_loading.dismiss();
            }

            @Override
            public void onFailure(Call<ArrayList<Movie>> call, Throwable t) {

            }
        });
    }


    @Override
    public void OnMovieListener(Movie movie) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(Constant.MOVIE_ID,movie.getId());
        intent.putExtra(Constant.MOVIE_AGE_LIMIT,movie.getAgeLimit());
        intent.putExtra(Constant.MOVIE_RATE,movie.getRate());
        intent.putExtra(Constant.MOVIE_TITLE,movie.getName());
        intent.putExtra(Constant.MOVIE_TYPE,movie.getTypeName());
        intent.putExtra(Constant.MOVIE_IMAGE,movie.getImage());

        selectedMovie.setAgeLimit(movie.getAgeLimit());
        selectedMovie.setId(movie.getId());
        selectedMovie.setImage(movie.getImage());
        selectedMovie.setName(movie.getName());
        selectedMovie.setRate(movie.getRate());
        selectedMovie.setTypeName(movie.getTypeName());

        startActivity(intent);
    }

    public void showLoading() {
        dialog_loading = new Dialog_loading();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        dialog_loading.show(fragmentManager,"OK");

    }
}