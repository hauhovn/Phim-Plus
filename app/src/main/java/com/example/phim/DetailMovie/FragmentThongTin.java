package com.example.phim.DetailMovie;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phim.Constant;
import com.example.phim.DetailMovie.Detail.Actor;
import com.example.phim.DetailMovie.Detail.ActorAdapter;
import com.example.phim.Home.Adapter.MovieAdapter;
import com.example.phim.Home.HomeFragment;
import com.example.phim.Home.Models.Movie;
import com.example.phim.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class FragmentThongTin extends Fragment {

    private View mRootView;
    ImageView imageView,img_trailer,img_background;
    TextView txtTitle, txtDetail, txtTheLoai,txt_gia,txt_dao_dien;
//    public  static  String linkTrailer,idMovie;
    Button btnMuaVe;
    RecyclerView re_actors;
    ImageButton btnBack;
//    @Nullable
//    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView =inflater.inflate(R.layout.fragment_thongtin,container,false);
//

        AnhXa();
        loadActorList();
//
//        GanGiaTri();
//
//
//
//        img_trailer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
//                // Create and show the dialog.4
//                Dialog_trailer newFragment = new Dialog_trailer ();
//                newFragment.show(ft, "dialog");
//            }
//        });
//
//        btnMuaVe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),Setup_ticket.class);
//                startActivity(intent);
//            }
//        });


        return mRootView;
    }
//    private void GanGiaTri() {
//
//        Movies thisMovie = new HomeFragment().phimClicked;
//        if(thisMovie.getId().equals("")){
//             thisMovie = new PhimDangChieuActivity().phimClicked;
//        }else if(thisMovie.getId().equals("")){
//            thisMovie = new PhimSapChieuActivity().phimClicked;
//        }
//
//        String title, daodien, theloai, gia,trailer;
//        String img ;
//
//        title = thisMovie.getName();
//        theloai = thisMovie.getTypeName();
//        img = thisMovie.getImage();
//        daodien = thisMovie.getDirector();
//        gia = thisMovie.getPrice();
//        trailer = thisMovie.getTrailer();
//        linkTrailer = trailer;
//        idMovie = thisMovie.getId();
//        Glide.with(this).load(img).into(imageView);
//
//        Picasso.with(getContext()).load(img).into(imageView);
//
//        txtTitle.setText(title);
//        txtTheLoai.setText(theloai);
//        txt_dao_dien.setText(daodien);
//        txt_gia.setText("Giá: "+gia+" VND");
//    }
//
//
//
    private void AnhXa() {

        Intent intent = new Intent();

        Movie thisMovie = new HomeFragment().selectedMovie;

        String img = intent.getStringExtra(Constant.MOVIE_IMAGE);
        String title = intent.getStringExtra(Constant.MOVIE_TITLE);
        String type = intent.getStringExtra(Constant.MOVIE_TYPE);
        String rate = intent.getStringExtra(Constant.MOVIE_RATE);
        String age_limit = intent.getStringExtra(Constant.MOVIE_AGE_LIMIT);

        Log.d("fff", ": img: "+img+" title: "+thisMovie.getName()+" type "+type);

        img_background = (ImageView)mRootView.findViewById(R.id.img_hinh_hen);
        Picasso.with(getContext())
                .load(R.string.background_movie_detail_link)
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
        txt_gia = (TextView) mRootView.findViewById(R.id.gia_ban);
        txt_dao_dien = (TextView)mRootView.findViewById(R.id.dao_tien);
        re_actors = (RecyclerView)mRootView.findViewById(R.id.fragment_thong_tin_RecyclerView_list_actors);

    }
    public void loadActorList() {
        ArrayList<Actor> data = new ArrayList<>();
        data.add(new Actor(1));data.add(new Actor(11));data.add(new Actor(12));
        data.add(new Actor(13));data.add(new Actor(14));data.add(new Actor(15));
        data.add(new Actor(1));data.add(new Actor(11));data.add(new Actor(12));
        data.add(new Actor(13));data.add(new Actor(14));data.add(new Actor(15));
        data.add(new Actor(1));data.add(new Actor(11));data.add(new Actor(12));
        data.add(new Actor(13));data.add(new Actor(14));data.add(new Actor(15));

        ActorAdapter actorAdapter = new ActorAdapter(getContext(),data);

        re_actors.setLayoutManager(new LinearLayoutManager(getActivity()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        re_actors.setLayoutManager(linearLayoutManager);
        re_actors.setAdapter(actorAdapter);
    }
}
