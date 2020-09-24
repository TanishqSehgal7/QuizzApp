package com.example.quizzapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.quizzapp.Adapter.ScoreViewHolder;
import com.example.quizzapp.Model.PreviousScoresModel;
import com.example.quizzapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScoresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScoresFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DatabaseReference reference_scores;
    RecyclerView recyclerView;
    FirebaseRecyclerAdapter adapter;
    View view;
    LottieAnimationView animationView;

    //    ArrayList<PreviousScoresModel> score_list;
    ArrayList<PreviousScoresModel> results_CategoryWise = new ArrayList<>();

    public ScoresFragment() {
        // Required empty public constructor
    }

    public static ScoresFragment newInstance(String param1, String param2) {
        ScoresFragment fragment = new ScoresFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_scores, container, false);
        recyclerView = view.findViewById(R.id.RvSocres);
        recyclerView.setVisibility(View.GONE);
        animationView=view.findViewById(R.id.loadingLottie);
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animationView.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        },2000);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FetchPreviousScores();
        return view;
    }

    private void FetchPreviousScores(){
        reference_scores = FirebaseDatabase.getInstance().getReference().child("Score").child("CategoryPreviousScore");

        FirebaseRecyclerOptions<PreviousScoresModel> options=new FirebaseRecyclerOptions.Builder<PreviousScoresModel>().setQuery(reference_scores, new SnapshotParser<PreviousScoresModel>() {
            @NonNull
            @Override
            public PreviousScoresModel parseSnapshot(@NonNull DataSnapshot snapshot) {
                return new PreviousScoresModel(snapshot.child("CategoryName").getValue().toString(),snapshot.child("PreviousScore").getValue().toString());
            }
        }).build();

        adapter= new FirebaseRecyclerAdapter<PreviousScoresModel, ScoreViewHolder>(options){

            @NonNull
            @Override
            public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.score_card, parent, false);
                return new ScoreViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ScoreViewHolder holder, int position, @NonNull PreviousScoresModel model) {
                holder.setPreviousScore(model.getPreviousScore());
                holder.setCategoryOfPreviousScore(model.getCategoryName());
            }
        };
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
