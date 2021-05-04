package com.example.studyedge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class staticRvAdapter extends RecyclerView.Adapter<staticRvAdapter.StaticRVViewHolder>{

    private ArrayList<staticRvModel> items;
    int row_index = -1;

    public staticRvAdapter(ArrayList<staticRvModel> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item,parent,false);
        StaticRVViewHolder staticRVViewHolder = new StaticRVViewHolder(view);
        return staticRVViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, int position) {
        staticRvModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();
            }
        });

        if(row_index == position){
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);
        }
        else{
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class StaticRVViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;

        public StaticRVViewHolder(@NonNull View itemview){
            super(itemview);
            imageView = itemview.findViewById(R.id.imagerv);
            textView = itemview.findViewById(R.id.textname);
            linearLayout = itemview.findViewById(R.id.linearlayot);
        }

    }
}
