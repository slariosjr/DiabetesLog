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

public class RecyclerLog extends RecyclerView.Adapter<RecyclerLog.ViewHolder> {

    Context context;
    List<LogD> arrayLogList = new ArrayList<>();

    public RecyclerLog(Context context, List<LogD> arrayNewsList) {
        this.context = context;
        this.arrayLogList = arrayNewsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_log, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(arrayLogList.get(position).getLogDate());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, " Log " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, NewLogDetails.class);
                intent.putExtra("Date", arrayLogList.get(position).getLogDate());
                intent.putExtra("Blood Sugar", arrayLogList.get(position).getBloodSugar());
                intent.putExtra("Insulin", arrayLogList.get(position).getInsulin());
                intent.putExtra("Carbs", arrayLogList.get(position).getCarbs());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayLogList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView;

        public ViewHolder(@NonNull View items) {
            super(items);

            textView = items.findViewById(R.id.LogDateCard);

            cardView = items.findViewById(R.id.LogCardView);

        }
    }
}