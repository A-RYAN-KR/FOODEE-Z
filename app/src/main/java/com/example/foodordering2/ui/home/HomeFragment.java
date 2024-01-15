package com.example.foodordering2.ui.home;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering2.R;
import com.example.foodordering2.adapters.HomeHorAdapter;
import com.example.foodordering2.adapters.HomeVerAdapter;
import com.example.foodordering2.adapters.UpdateVerticalRec;
import com.example.foodordering2.models.HomeHorModel;
import com.example.foodordering2.models.HomeVerModel;

import java.util.ArrayList;



public class HomeFragment extends Fragment implements UpdateVerticalRec {

    String Name;
    String Email;
    TextView homeName;
    TextView emailHome;
    TextView fullName;
    String Username;
    RecyclerView homeHorizontalRec, homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            Name = arguments.getString("name");
            Email = arguments.getString("email");
            Username = arguments.getString("username");
            TextView homeUsername = root.findViewById(R.id.home_username);
            homeUsername.setText("Hello " +Username);

        }

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        homeHorModelList = new ArrayList<>();
        homeHorModelList.add(new HomeHorModel(R.drawable.copy_of_pizza, "Paratha"));
        homeHorModelList.add(new HomeHorModel(R.drawable.copy_of_hamburger, "Snacks"));
        homeHorModelList.add(new HomeHorModel(R.drawable.copy_of_fried_potatoes, "Shakes"));
        homeHorModelList.add(new HomeHorModel(R.drawable.copy_of_icecream, "Tea/Coffee"));
        homeHorModelList.add(new HomeHorModel(R.drawable.copy_of_sandwich, "Sandwich"));

        homeHorAdapter = new HomeHorAdapter(this, getActivity(), homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        homeVerModelList = new ArrayList<>();
        // Add items to homeVerModelList if needed

        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        ImageView yourImageView = root.findViewById(R.id.profile);
        yourImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg) {
                // custom dialog
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.custom_dialog);
                homeName = dialog.findViewById(R.id.userName_home);
                emailHome = dialog.findViewById(R.id.email_home);
                fullName = dialog.findViewById(R.id.name_home);
                fullName.setText(Name);
                homeName.setText(Username);
                emailHome.setText(Email);
                dialog.show();
            }
        });

        return root;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter = new HomeVerAdapter(getContext(), list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);
    }

}
