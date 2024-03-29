package com.gmail.gosnellwebdesign.veteransmuseumprototype;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/*
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;

    String[]  data1;
    String[]  data2;

    //	Constructor
    public MyAdapter(Context ct, String[] s1, String[] s2) {
        context = ct;
        data1 = s1;
        data2 = s2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondaryActivity.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  myText1;
        TextView  myText2;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1     = itemView.findViewById(R.id.myText1);
            myText2     = itemView.findViewById(R.id.myText2);
            mainLayout  = itemView.findViewById(R.id.mainLayout);
        }
    }
}
*/
