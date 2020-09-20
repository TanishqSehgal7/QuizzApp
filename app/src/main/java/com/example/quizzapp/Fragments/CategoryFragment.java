package com.example.quizzapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzapp.Adapter.CategoryRVAdapter;
import com.example.quizzapp.Model.Category;
import com.example.quizzapp.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView CategoryRv;
    List<Category> categoryList;
    View view;

    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        categoryList= new ArrayList<>();

        categoryList.add(new Category("Art and Literature", R.drawable.artandliterature));

        categoryList.add(new Category("General Knowledge",R.drawable.generalknowledge));

        categoryList.add(new Category("History",R.drawable.history));

        categoryList.add(new Category("Technology",R.drawable.technology));

        categoryList.add(new Category("Sports",R.drawable.sports));

        categoryList.add(new Category("Politics",R.drawable.politics));

        categoryList.add(new Category("Geography",R.drawable.geography));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_category,container,false);
        CategoryRv= (RecyclerView) view.findViewById(R.id.categoryRV);
        CategoryRVAdapter adapter= new CategoryRVAdapter(getContext(),categoryList);
        CategoryRv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        CategoryRv.setAdapter(adapter);
        return view;
    }
}