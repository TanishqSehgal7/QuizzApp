package com.example.quizzapp;

import android.content.Context;
import android.util.SparseLongArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.CategoryViewHolder> {

    private Context mcontext;
    private List<Category> mData;
    View view;

    public CategoryRVAdapter(Context mcontext, List<Category> mData) {
        this.mcontext=mcontext;
        this.mData=mData;
    }

    @NonNull
    @Override
    public CategoryRVAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mcontext);
        view=inflater.inflate(R.layout.category_item,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRVAdapter.CategoryViewHolder holder, int position) {

        holder.category_name.setText(mData.get(position).getCategoryName());
        holder.category_image.setImageResource(mData.get(position).getCategoryPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView category_name;
        ImageView category_image;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            category_name=itemView.findViewById(R.id.category_name);
            category_image=itemView.findViewById(R.id.category_image);
        }
    }

}
