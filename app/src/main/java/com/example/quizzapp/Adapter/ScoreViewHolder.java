package com.example.quizzapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizzapp.Fragments.ScoresFragment;
import com.example.quizzapp.Model.PreviousScoresModel;
import com.example.quizzapp.R;

import java.util.List;


    public class ScoreViewHolder extends RecyclerView.ViewHolder{

        TextView categoryOfPrevoousScore;
        TextView PreviousScore;

        public ScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryOfPrevoousScore=itemView.findViewById(R.id.category_name_socre);
            PreviousScore=itemView.findViewById(R.id.previous_score);
        }

        public void setCategoryOfPreviousScore(String string) {
            categoryOfPrevoousScore.setText("Category  Name :"+string);
        }


        public void setPreviousScore(String string) {
            PreviousScore.setText("Score: "+string);
        }
    }
