package com.example.phim.DetailMovie.Detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phim.R;

import java.util.ArrayList;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.MyViewHolder> {

        Context context;
        ArrayList<Actor> mData = new ArrayList<>();

public ActorAdapter(Context context, ArrayList<Actor> mData)
        {
        this.context = context;
        this.mData = mData;
        }


@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_actor, parent, false);

        return new MyViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        }

@Override
public int getItemCount() {
        return mData.size();
        }

public class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView txtTime, txtCinema,txtBranch;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);


    }
}
}