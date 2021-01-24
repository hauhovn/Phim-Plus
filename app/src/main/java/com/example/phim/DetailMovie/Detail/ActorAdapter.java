package com.example.phim.DetailMovie.Detail;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phim.R;
import com.squareup.picasso.Picasso;

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

    holder.txt_name.setText(mData.get(position).getName());
    Picasso.with(context)
            .load(mData.get(position).getImage())
            .placeholder(R.drawable.ic_download_24)
            .error(R.drawable.ic_error_24)
            .into(holder.img);
    Log.d("fff", "onBindViewHolder: img: "+mData.get(position).getImage() + "  onBindViewHolder: name: "+mData.get(position).getName());
}

@Override
public int getItemCount() {
        return mData.size();
        }

public class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView txt_name;
    private ImageView img;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_name = (TextView)itemView.findViewById(R.id.item_actor_name);
        img = (ImageView)itemView.findViewById(R.id.item_actor_img);

    }
}
}