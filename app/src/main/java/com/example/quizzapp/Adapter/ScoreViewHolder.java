package com.example.quizzapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizzapp.Model.PreviousScoresModel;
import com.example.quizzapp.Quiz.ArtAndLiterature;
import com.example.quizzapp.Quiz.Technology;
import com.example.quizzapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ScoreViewHolder extends RecyclerView.ViewHolder {

    public TextView previous_score, score_category;
    public ImageView category_image;

    public ScoreViewHolder(@NonNull View itemView) {
        super(itemView);
        previous_score=itemView.findViewById(R.id.previous_score);
        score_category=itemView.findViewById(R.id.category_name_socre);
        category_image=itemView.findViewById(R.id.category_image_score);
    }
}
