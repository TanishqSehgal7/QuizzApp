package com.example.quizzapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.transition.Fade;
import android.util.SparseLongArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.Random;

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
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mcontext);
        view=inflater.inflate(R.layout.category_item,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder holder, final int position) {

        holder.category_name.setText(mData.get(position).getCategoryName());
        holder.category_image.setImageResource(mData.get(position).getCategoryPhoto());
        holder.rvitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(mcontext, QuestionsActivity.class);
//                    intent.putExtra("Category Name",mData.get(position).getCategoryName());
                    intent.putExtra("Category Image",mData.get(position).getCategoryPhoto());
                    ActivityOptionsCompat options=ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mcontext,holder.category_image, ViewCompat.getTransitionName(holder.category_image));
                    mcontext.startActivity(intent,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView category_name;
        ImageView category_image;
        CardView rvitem;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            category_name=itemView.findViewById(R.id.category_name);
            category_image=itemView.findViewById(R.id.category_image);
            rvitem=itemView.findViewById(R.id.RVItem);
        }
    }
}
