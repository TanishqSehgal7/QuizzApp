package com.example.quizzapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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

import com.example.quizzapp.Model.Category;
import com.example.quizzapp.Quiz.GeneralKnowledge;
import com.example.quizzapp.Quiz.Geography;
import com.example.quizzapp.Quiz.History;
import com.example.quizzapp.Quiz.Politics;
import com.example.quizzapp.Quiz.ArtAndLiterature;
import com.example.quizzapp.Quiz.Sports;
import com.example.quizzapp.Quiz.Technology;
import com.example.quizzapp.R;

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
                if (position==0) {
                    Intent intent = new Intent(mcontext, ArtAndLiterature.class);
                    intent.putExtra("Category Image", mData.get(position).getCategoryPhoto());
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mcontext, holder.category_image, ViewCompat.getTransitionName(holder.category_image));
                    mcontext.startActivity(intent, options.toBundle());
                } else if (position==1){
                    Intent intent = new Intent(mcontext, GeneralKnowledge.class);
                    intent.putExtra("Category Image", mData.get(position).getCategoryPhoto());
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mcontext, holder.category_image, ViewCompat.getTransitionName(holder.category_image));
                    mcontext.startActivity(intent, options.toBundle());
                } else if (position==2){
                    Intent intent = new Intent(mcontext, History.class);
                    intent.putExtra("Category Image", mData.get(position).getCategoryPhoto());
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mcontext, holder.category_image, ViewCompat.getTransitionName(holder.category_image));
                    mcontext.startActivity(intent, options.toBundle());
                } else if (position==3){
                    Intent intent = new Intent(mcontext, Technology.class);
                    intent.putExtra("Category Image", mData.get(position).getCategoryPhoto());
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mcontext, holder.category_image, ViewCompat.getTransitionName(holder.category_image));
                    mcontext.startActivity(intent, options.toBundle());
                } else if (position==4){
                    Intent intent = new Intent(mcontext, Sports.class);
                    intent.putExtra("Category Image", mData.get(position).getCategoryPhoto());
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mcontext, holder.category_image, ViewCompat.getTransitionName(holder.category_image));
                    mcontext.startActivity(intent, options.toBundle());
                } else if (position==5){
                    Intent intent = new Intent(mcontext, Politics.class);
                    intent.putExtra("Category Image", mData.get(position).getCategoryPhoto());
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mcontext, holder.category_image, ViewCompat.getTransitionName(holder.category_image));
                    mcontext.startActivity(intent, options.toBundle());
                }
                else if (position==6){
                    Intent intent = new Intent(mcontext, Geography.class);
                    intent.putExtra("Category Image", mData.get(position).getCategoryPhoto());
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mcontext, holder.category_image, ViewCompat.getTransitionName(holder.category_image));
                    mcontext.startActivity(intent, options.toBundle());
                }
            }
        });

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.category_name.setBackgroundColor(color);
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
