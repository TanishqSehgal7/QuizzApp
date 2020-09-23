package com.example.quizzapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzapp.Adapter.ScoreViewHolder;
import com.example.quizzapp.Model.PreviousScoresModel;
import com.example.quizzapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    View view;
    FirebaseRecyclerAdapter<PreviousScoresModel, ScoreViewHolder> adapter;
//    ArrayList<PreviousScoresModel> score_list;

    public ScoresFragment() {
        // Required empty public constructor
    }

    public static ScoresFragment newInstance(String param1, String param2) {
        ScoresFragment fragment = new ScoresFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        reference_scores= FirebaseDatabase.getInstance().getReference().child("Score").child("CategoryPreviousScore");
        view=inflater.inflate(R.layout.fragment_scores,container,false);
        recyclerView=view.findViewById(R.id.RvSocres);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        showScores();
        return view;
    }

    private void showScores(){
        FirebaseRecyclerOptions options=
                new FirebaseRecyclerOptions.Builder<PreviousScoresModel>()
                        .setQuery(reference_scores,PreviousScoresModel.class)
                        .build();
        adapter=new FirebaseRecyclerAdapter<PreviousScoresModel, ScoreViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ScoreViewHolder holder, int position, @NonNull PreviousScoresModel model) {
                    holder.previous_score.setText(model.getPreviousScore());
            }

            @NonNull
            @Override
            public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                view=LayoutInflater.from(getContext()).inflate(R.layout.score_card,parent,false);
                return new ScoreViewHolder(view);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}
