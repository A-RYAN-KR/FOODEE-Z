package com.example.foodordering2.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering2.R;
import com.example.foodordering2.models.HomeHorModel;
import com.example.foodordering2.models.HomeVerModel;

import java.util.ArrayList;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;
    boolean check = true;
    int row_index = -1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if (check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza1, "Aloo Paratha", "10:00 - 18:00", "4.9", "50"));
            homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza2, "Paneer Paratha", "10:00 - 18:00", "4.9", "70"));
            homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza3, "Palak Paratha", "10:00 - 18:00", "4.9", "55"));
            homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza4, "Rava Paratha", "10:00 - 18:00", "4.9", "60"));
            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();

                if (position == 0) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza1, "Aloo Paratha", "10:00 - 18:00", "4.9", "50"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza2, "Paneer Paratha", "10:00 - 18:00", "4.9", "70"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza3, "Palak Paratha", "10:00 - 18:00", "4.9", "55"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza4, "Rava Paratha", "10:00 - 18:00", "4.9", "60"));
                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 1) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_burger1, "Vada Pav", "10:00 - 18:00", "4.9", "18"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_burger2, "Sabudana Vada", "18:00 - 23:00", "4.9", "25"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_burger3, "Poha", "10:00 - 18:00", "4.9", "25"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_burger4, "Shev Pav", "10:00 - 18:00", "4.9", "25"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_burger5, "Samosa", "10:00 - 18:00", "4.9", "17"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_burger6, "Patties", "10:00 - 18:00", "4.9", "22"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_burger7, "Idli", "10:00 - 18:00", "4.9", "35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_burger8, "Dhokla", "10:00 - 18:00", "4.9", "35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_burger9, "Pulav", "10:00 - 18:00", "4.9", "60"));
                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 2) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries1, "Banana Shake", "10:00 - 23:00", "4.9", "35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries2, "Chiku Shake", "10:00 - 23:00", "4.9", "40"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries3, "Stawberry Shake", "10:00 - 23:00", "4.9", "40"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries4, "Papaya Shake", "10:00 - 23:00", "4.9", "40"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries5, "Musk Melon Shake", "10:00 - 23:00", "4.9", "40"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries6, "Rose Shake", "10:00 - 23:00", "4.9", "40"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries7, "Anjeer Shake", "10:00 - 23:00", "4.9", "40"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries8, "Butter Scotch Shake", "10:00 - 23:00", "4.9", "40"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries9, "Bournvita Shake", "10:00 - 23:00", "4.9", "45"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries10, "Oreo Shake", "10:00 - 23:00", "4.9", "45"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries11, "Gajar Shake", "10:00 - 23:00", "4.9", "40"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries12, "Cold Coffee", "10:00 - 18:00", "4.9", "40"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries13, "Mango Shake", "10:00 - 18:00", "4.9", "50"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries14, "Pineapple Shake", "10:00 - 18:00", "4.9", "45"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries15, "Chocolate Shake", "10:00 - 18:00", "4.9", "50"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries16, "Khajoor Shake", "10:00 - 18:00", "4.9", "50"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries17, "Apple Shake", "10:00 - 18:00", "4.9", "50"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries18, "Dragon Fruit", "10:00 - 18:00", "4.9", "50"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries19, "Kiwi Shake", "10:00 - 18:00", "4.9", "60"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries20, "Sitafal Shake", "10:00 - 18:00", "4.9", "70"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries21, "Pista Shake", "10:00 - 18:00", "4.9", "60"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries22, "Badam Shake", "10:00 - 18:00", "4.9", "60"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries23, "Keasar Shake", "10:00 - 18:00", "4.9", "60"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries24, "Mix Fruit Shake", "10:00 - 18:00", "4.9", "60"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries25, "Sitafal Rabdi", "10:00 - 18:00", "4.9", "90"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries26, "Stawberry Rabdi", "10:00 - 18:00", "4.9", "60"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries27, "Pineapple Rabdi", "10:00 - 18:00", "4.9", "60"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries28, "Chiku Rabdi", "10:00 - 18:00", "4.9", "55"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries29, "Mix Rabdi", "10:00 - 18:00", "4.9", "60"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries30, "Dragon Fruit", "10:00 - 18:00", "4.9", "60"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries31, "Kiwi Rabdi", "10:00 - 18:00", "4.9", "70"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries32, "Apple Rabdi", "10:00 - 18:00", "4.9", "60"));

                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 3) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_image1, "Tea", "10:00 - 18:00", "4.9", "15"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_image2, "Coffee", "10:00 - 18:00", "4.9", "20"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_image3, "Hot Coffee", "10:00 - 18:00", "4.9", "15"));
                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 4) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_sandwitch1, "Veg Grilled", "10:00 - 18:00", "4.9", "55"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_sandwitch2, "Chocolate", "10:00 - 18:00", "4.9", "55"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_sandwitch3, "Aalu grilled", "10:00 - 18:00", "4.9", "50"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_sandwitch4, "Paneer Grilled", "10:00 - 18:00", "4.9", "60"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_sandwitch5, "Veg Plain", "10:00 - 18:00", "4.9", "40"));
                    updateVerticalRec.callBack(position, homeVerModels);
                }
            }
        });

        // Change background color only for the clicked item
        if (row_index == position) {
            holder.cardView.setBackgroundResource(R.drawable.change_bg);
        } else {
            holder.cardView.setBackgroundResource(R.drawable.default_bg);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
