package com.example.phim.Home.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phim.Constant;
import com.example.phim.Home.Models.Movie;
import com.example.phim.R;
import com.example.phim.SaveData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter
        extends RecyclerView.Adapter<MovieAdapter.RecyclerViewHolder> {

    ArrayList<Movie> mListMovie;
    private Context context;
    private OnMovieListener onMovieListener;
    public String movieID;

    public MovieAdapter(Context context, ArrayList<Movie> mListCommemt,OnMovieListener  onMovieListener) {
        this.mListMovie = mListCommemt;
        this.context =context;
        this.onMovieListener = onMovieListener;  }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View commentView = inflater.inflate(R.layout.item_movie,parent,false);

        // Return a new holder instance
        return  new RecyclerViewHolder(commentView,onMovieListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Get the data model based on position
        Movie movie = mListMovie.get(position);
        // Set item views based on your views and data model
        String title = mListMovie.get(position).getName();
        holder.txt_name.setText(title);

        String type = mListMovie.get(position).getTypeName();
        holder.txt_type.setText(type);

        String ageLimit = mListMovie.get(position).getAgeLimit();
        holder.txt_ageLimit.setText(ageLimit);

        String rate = mListMovie.get(position).getRate();
        holder.txt_rate.setText(rate);

        String img = mListMovie.get(position).getImage();
        Picasso.with(context)
                .load(img)
                .error(R.drawable.ic_error_24)
                .placeholder(R.drawable.ic_download_24)
                .into(holder.img);
        movieID = mListMovie.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return mListMovie.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnMovieListener onMovieListener;

        public TextView txt_rate, txt_ageLimit, txt_name, txt_type;
        public ImageView img;

        public RecyclerViewHolder(final View itemView, OnMovieListener onMovieListener){
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.item_movie_image);
            txt_rate = (TextView) itemView.findViewById(R.id.item_movie_rate);
            txt_ageLimit = (TextView) itemView.findViewById(R.id.item_movie_ageLimit);
            txt_name = (TextView) itemView.findViewById(R.id.item_movie_title);
            txt_type = (TextView) itemView.findViewById(R.id.item_movie_theloai);
            this.onMovieListener = onMovieListener;

            //Click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMovieListener.OnMovieListener(mListMovie.get(getAdapterPosition()));
                }
            });

        }

        @Override
        public void onClick(View v) {
            onMovieListener.OnMovieListener(mListMovie.get(getAdapterPosition()));
            RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(v,onMovieListener);
        }

    }

    public interface OnMovieListener{
        void OnMovieListener(Movie movie);
    }


}
