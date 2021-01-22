package com.example.phim.DetailMovie;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.phim.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBinhLuan extends Fragment{//implements CommentAdapter.OnCommentListener {

    // Add RecyclerView member
//    private RecyclerView recyclerView;
    View mRootview;
//    ArrayList<Comment> listComments = new ArrayList<Comment>();
//    TextView txt_more,txt_content;
//    ProgressDialog nDialog;
//
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootview = inflater.inflate(R.layout.fragment_binhluan,container,false);


//        init();
//
//        com.chau.phimplus.ui.movie_detail.FragmentThongTin fk = new com.chau.phimplus.ui.movie_detail.FragmentThongTin();
//        Log.d("fff", "onCreateView: "+fk.idMovie);
//        getComment(fk.idMovie);
//
//        // Create adapter passing in the sample user data
//        CommentAdapter commentAdapter = new CommentAdapter(getContext(),listComments,this);
//
//        // Set layout manager to position the items
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(commentAdapter);
        // finally
        return mRootview;
    }

//    private void init() {
//        //dialog loading
//        nDialog = new ProgressDialog(getContext());
//        nDialog.setMessage("Loading.. ^^");
//        nDialog.setIndeterminate(false);
//        nDialog.setCancelable(false);
//        // Add the following lines to create RecyclerView
//        recyclerView = (RecyclerView) mRootview.findViewById(R.id.recylerview_comment);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setItemViewCacheSize(20);
//        recyclerView.setLayoutManager(new LinearLayoutManager(mRootview.getContext()));
//    }
//
//    @Override
//    public void OnCommentClick(int position) {
////        listComments.get(position);
//
//    }
//
//    public ArrayList<Comment> getComment(final String movieId){
//
//        Dataserver dataserver = APIserver.getServer();
//
//        Call<ArrayList<Comment>> callback = dataserver.getComment(movieId);
//        callback.enqueue(new Callback<ArrayList<Comment>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
//                listComments = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {
//
//            }
//        });
//
//
//        return null;
//    }
//

}



