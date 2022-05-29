package com.example.botoom_with_nav.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.botoom_with_nav.Listner.OnBottomItemNavigationListner;
import com.example.botoom_with_nav.Model.BottomNavigationModel;
import com.example.botoom_with_nav.R;

import java.util.ArrayList;

public class RecyclerBottomNavigationAdapter extends RecyclerView.Adapter<RecyclerBottomNavigationAdapter.ViewHolder> {

    public static  final  int ITEM_HOME =0;
    public static  final  int ITEM_DASHBOARD =1;
    public static  final  int ITEM_SETTINGS =2;
    private int  clickItem = ITEM_HOME;


    private ArrayList<BottomNavigationModel> bottomNavigationModelArray;
    private Context context;
    private OnBottomItemNavigationListner bottomItemNavigationListner;

    public RecyclerBottomNavigationAdapter(ArrayList<BottomNavigationModel> bottomNavigationModelArray, Context context, OnBottomItemNavigationListner bottomItemNavigationListner) {
        this.bottomNavigationModelArray = bottomNavigationModelArray;
        this.context = context;
        this.bottomItemNavigationListner = bottomItemNavigationListner;
    }

    @NonNull
    @Override
    public RecyclerBottomNavigationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_bottom_nav_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerBottomNavigationAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {


        BottomNavigationModel bottomNavigationModel = bottomNavigationModelArray.get(position);
        holder.textTitle.setText(bottomNavigationModel.getTitle());
        if (clickItem == position ){
            holder.imgIcon.setImageResource(bottomNavigationModel.getNormalIcon());
            holder.textTitle.setTextColor(context.getResources().getColor(R.color.black));
        }
        else {
            holder.imgIcon.setImageResource(bottomNavigationModel.getClickItemIcon());
            holder.textTitle.setTextColor(context.getResources().getColor(R.color.light_blue));
        }

        holder.innerItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomItemNavigationListner!= null){
                    bottomItemNavigationListner.OnItemClicked(position);

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return bottomNavigationModelArray.size();
    }

    public void changeItem(int item ){
        clickItem = item;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout innerItem;
        ImageView imgIcon;
        TextView textTitle;
        public ViewHolder(@NonNull View view) {
            super(view);

      innerItem = view.findViewById(R.id.innerItem);
      imgIcon = view.findViewById(R.id.imgIcon);
      textTitle = view.findViewById(R.id.textTitle);
        }
    }
}
