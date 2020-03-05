package com.gmail.gosnellwebdesign.recyclerviewblues;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//The HockeyTeam class is responsible for creating
//the ViewHolder objects and also for binding the data to them.

//NOTE:This class extends the RecyclerView.Adapter class and manages
//the ViewHold objects
public class HockeyTeamAdapter extends RecyclerView.Adapter<HockeyTeamAdapter.ViewHolder>{
    public List<HockeyTeam> teamList;
    //Full-Arg constructor
    //The adapter is responsible for creating the ViewHolder objects as needed
    //It also creates new viewHolder objects as the user scrolls through the list of items
    public HockeyTeamAdapter(List<HockeyTeam> bluesTeamList){
        teamList = bluesTeamList;
    }

    //Note: There are three methods that must be overridden when using the adapter. They are shown below.
    //Also: It is customary to define the ViewHolder class inside of the adapter class. This inner class
    //initializes the textViews

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvPositionPlayed;
        TextView tvNumber;

        //Full-Arg Constructor
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPositionPlayed = itemView.findViewById(R.id.tvPositionPlayed);
            tvNumber = itemView.findViewById(R.id.tvNumber);


        }
    }
    //The onCreateViewHolder() method is used for creating the ViewHolder and inflating the layout
    //created earlier inside it
    public HockeyTeamAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    //The onBinderViewHolder() method is used to bind the data to
    //the ViewHolder. It determines the data that needs to be
    //displayed based on the list position. It is populated by the ViewHolder
    @Override
    public void onBindViewHolder(HockeyTeamAdapter.ViewHolder holder, int position){
        holder.tvName.setText(teamList.get(position).getName());
        holder.tvPositionPlayed.setText(teamList.get(position).getPositionPlayed());
        holder.tvNumber.setText(teamList.get(position).getNumber());
    }

    //The getItemCount() method returns the size of the dataset,
    //i.e. the number of items in the dataset
    @Override
    public int getItemCount(){
        return teamList.size();
    }


} //End public class HockeyTeamAdapter


