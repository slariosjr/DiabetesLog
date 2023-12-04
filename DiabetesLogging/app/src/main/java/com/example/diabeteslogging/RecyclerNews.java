package com.example.diabeteslogging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerNews extends RecyclerView.Adapter<RecyclerNews.ViewHolder> {

    Context context;
    List<News> arrayNewsList = new ArrayList<>();
    public RecyclerNews(Context context, List<News> arrayNewsList){
        this.context = context;
        this.arrayNewsList = arrayNewsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_news,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(arrayNewsList.get(position).getTopicTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context," News "+position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, NewsDetails.class);
                intent.putExtra("Title", arrayNewsList.get(position).getTopicTitle());
                intent.putExtra("Summary",arrayNewsList.get(position).getNewsSummary());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayNewsList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textView;
        public ViewHolder(@NonNull View items){
            super(items);

            textView = items.findViewById(R.id.NewsTitle);

            cardView = items.findViewById(R.id.NewsCardView);

        }
    }
}
