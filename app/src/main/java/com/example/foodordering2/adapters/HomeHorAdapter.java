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
            homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza1, "Pizza 1", "10:00 - 23:00", "4.9", "Min - $35"));
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
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza1, "Pizza 1", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza2, "Pizza 2", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza3, "Pizza 3", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_pizza4, "Pizza 4", "10:00 - 23:00", "4.9", "Min - $35"));
                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 1) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_burger1, "Burger 1", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_burger2, "Burger 2", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_burger4, "Burger 3", "10:00 - 23:00", "4.9", "Min - $35"));
                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 2) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries1, "Fries 1", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries2, "Fries 2", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries3, "Fries 3", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_fries4, "Fries 4", "10:00 - 23:00", "4.9", "Min - $35"));
                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 3) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_icecream1, "Ice-cream 1", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_icecream3, "Ice-cream 2", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_icecream4, "Ice-cream 3", "10:00 - 23:00", "4.9", "Min - $35"));
                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 4) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_sandwich1, "Sandwich 1", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_sandwich2, "Sandwich 2", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_sandwich3, "Sandwich 3", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.copy_of_sandwich4, "Sandwich 4", "10:00 - 23:00", "4.9", "Min - $35"));
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
