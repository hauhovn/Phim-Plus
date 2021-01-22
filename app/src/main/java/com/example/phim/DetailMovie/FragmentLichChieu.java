package com.example.phim.DetailMovie;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
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

public class FragmentLichChieu extends Fragment {// implements View.OnClickListener {

//    String arrBranch[];
    private View mRootView;
//    Spinner spinner_branch;
//    private LinearLayout MasterLayout;
//    public ArrayList<LichChieu> mLichChieu = new ArrayList<>();
//    RecyclerView re_lichChieu;
//
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        mRootView =inflater.inflate(R.layout.fragment_lichchieu,container,false);
        //
//        anhXa();
//        setData();
//
//
//
//        loaddata();
//
//        Log.d("fff", "onCreateView: "+mLichChieu.size());
//        // Create adapter passing in the sample user data


        //
        return mRootView;
    }
//
//    private void loaddata() {
//        Dataserver dataserver = APIserver.getServer();
//
//        Movies thisMovie = new HomeFragment().phimClicked;
//        if(thisMovie.getId().equals("")){
//            thisMovie = new PhimDangChieuActivity().phimClicked;
//        }else if(thisMovie.getId().equals("")){
//            thisMovie = new PhimSapChieuActivity().phimClicked;
//        }
//
//        Call<ArrayList<LichChieu>> callback = dataserver.getSreening(thisMovie.getId());
//        callback.enqueue(new Callback<ArrayList<LichChieu>>() {
//            @Override
//            public void onResponse(Call<ArrayList<LichChieu>> call, Response<ArrayList<LichChieu>> response) {
//                for (LichChieu item:response.body()) {
//                    Log.d("fff", "loaddata: "+item.getName());
//                    mLichChieu.add(item);}
//
//                    LichChieuAdapter lichChieuAdapter = new LichChieuAdapter(getContext(),mLichChieu);
//
//                    // Set layout manager to position the items
//                    re_lichChieu.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//                    re_lichChieu.setAdapter(lichChieuAdapter);
//
//
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<LichChieu>> call, Throwable t) {
//
//            }
//        });
//    }
//
//    private void createLayout(LinearLayout _rootCView, Integer _SubId) {
//        // new layout
//        LinearLayout mLayout = new LinearLayout(getActivity());
//        mLayout.setGravity(View.TEXT_ALIGNMENT_CENTER);
//        mLayout.setVerticalGravity(LinearLayout.VERTICAL);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        mLayout.setLayoutParams(params);
//        mLayout.setBackgroundColor(Color.RED);
//        //mLayout.setId(_SubId);
//        // add TEXT VIEW
//        createTextView(mLayout,_SubId,"TITLE in here!" + "\t ID="+ Integer.toString(mLayout.getId()));
//
//        _rootCView.addView(mLayout);
//    }
//    private void createTextView(LinearLayout _rootView, Integer _SubId, String _content){
//        TextView textView = new TextView(getActivity());
//        textView.setId(_SubId);
//        LinearLayout.LayoutParams size = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        textView.setLayoutParams(size);
//        textView.setText(_content);
//        textView.setGravity(Gravity.CENTER);
//
//        _rootView.addView(textView);
//    }
//
//
//    private  void setData() {
//       arrBranch = new String[]{"Lê Thánh Tôn", "Bình Long","Trung Sơn"};
//    }
//
//
//    private void anhXa() {
//        re_lichChieu = (RecyclerView)mRootView.findViewById(R.id.re_lich_chieu);
//    }
//
//
//    @Override
//    public void onClick(View v) {
//
//
//    }

}
