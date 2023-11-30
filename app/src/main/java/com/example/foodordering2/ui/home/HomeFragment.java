package com.example.foodordering2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering2.R;
import com.example.foodordering2.adapters.HomeHorAdapter;
import com.example.foodordering2.adapters.HomeVerAdapter;
import com.example.foodordering2.adapters.UpdateVerticalRec;
import com.example.foodordering2.databinding.FragmentHomeBinding;
import com.example.foodordering2.models.HomeHorModel;
import com.example.foodordering2.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec, homeVerticalRec;
    List<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    List<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);
        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new HomeHorModel(R.drawable.copy_of_pizza, "Pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.copy_of_hamburger, "HamBurger"));
        homeHorModelList.add(new HomeHorModel(R.drawable.copy_of_fried_potatoes, "Fries"));
        homeHorModelList.add(new HomeHorModel(R.drawable.copy_of_ice_cream, "Ice Cream"));
        homeHorModelList.add(new HomeHorModel(R.drawable.copy_of_sandwich, "Sandwich"));

        homeHorAdapter = new HomeHorAdapter(this, (FragmentActivity) getActivity(), homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        homeVerModelList = new ArrayList<>();

        homeVerModelList.add(new HomeVerModel(R.drawable.copy_of_pizza1, "Pizza", "10:00 - 23:00", "4.9", "Min - $34"));
        homeVerModelList.add(new HomeVerModel(R.drawable.copy_of_pizza2, "Pizza", "10:00 - 23:00", "4.9", "Min - $34"));
        homeVerModelList.add(new HomeVerModel(R.drawable.copy_of_pizza3, "Pizza", "10:00 - 23:00", "4.9", "Min - $34"));

        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        homeVerticalRec.setHasFixedSize(true);
        homeVerticalRec.setNestedScrollingEnabled(false);

        return root;
    }

    @Override
    public void callBack(int position, List<HomeVerModel> homeVerModels) {
        // Implement the callback logic here
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {

    }
}
