package com.gmail.gosnellwebdesign.veteransmuseumfull;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<Model> dataset;
    private Context mContext;
    public RecyclerViewAdapter(ArrayList<Model> mlist, Context context) {
        this.dataset = mlist;
        this.mContext = context;
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder{


        TextView title, subtitle;
        ImageView imageView;
        public ImageTypeViewHolder(View itemView) {
            super(itemView);

            // Widget references
            this.title = (TextView)  itemView.findViewById(R.id.title);
            this.subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            this.imageView = (ImageView) itemView.findViewById(R.id.Icon);
        }
    }
    @Override
    // Set parent group for posts and return to view
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.postdetails, parent, false);
        return new ImageTypeViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final Model object = dataset.get(position);

        // Set title and subtitle of posts
        ( (ImageTypeViewHolder) holder).title.setText( object.title );
        ( (ImageTypeViewHolder) holder).subtitle.setText( object.subtitle );

        ( (ImageTypeViewHolder) holder).title.setOnClickListener(new View.OnClickListener() {
            @Override
            // Set title for intent which forwards to post activity screens
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WPPostDetails.class);
                intent.putExtra("itemPosition", position);
                mContext.startActivity(intent);
            }
        });
        ( (ImageTypeViewHolder) holder).subtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            // Set subtitle for intent which forwards to post activity screens
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WPPostDetails.class);
                intent.putExtra("itemPosition", position);
                mContext.startActivity(intent);
            }
        });
        ( (ImageTypeViewHolder) holder).imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            // Set image for intent which forwards to post activity screens
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WPPostDetails.class);
                intent.putExtra("itemPosition", position);
                mContext.startActivity(intent);
            }
        });

        /// dataset.get(position)
    }

    @Override
    public int getItemCount() {
        return dataset.size() ;
    }
}
