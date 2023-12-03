package com.example.foodordering2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodordering2.R;
import com.example.foodordering2.adapters.FeaturedAdapter;
import com.example.foodordering2.models.FeaturedModel;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {

    List<FeaturedModel> featuredModelList;
    RecyclerView recyclerView;
    FeaturedAdapter featuredAdapter;
    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        recyclerView = view.findViewById(R.id.featured_hor_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        featuredModelList = new ArrayList<>();

        featuredModelList.add(new FeaturedModel(R.drawable.copy_of_fav1,"Featured 1","Description 1"));
        featuredModelList.add(new FeaturedModel(R.drawable.copy_of_fav2,"Featured 2","Description 2"));
        featuredModelList.add(new FeaturedModel(R.drawable.copy_of_fav3,"Featured 3","Description 3"));

        featuredAdapter = new FeaturedAdapter(featuredModelList);
        recyclerView.setAdapter(featuredAdapter);
    return view;
    }
}