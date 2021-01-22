package com.gtappdevelopers.instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FacebookFeedRVAdapter extends RecyclerView.Adapter<FacebookFeedRVAdapter.ViewHolder> {
    //arraylist for our facebook feeds.
    private ArrayList<FacebookFeedModal> facebookFeedModalArrayList;
    private Context context;

    //creating a constructor for our adapter class.
    public FacebookFeedRVAdapter(ArrayList<FacebookFeedModal> facebookFeedModalArrayList, Context context) {
        this.facebookFeedModalArrayList = facebookFeedModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public FacebookFeedRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating our layout for item of recycler view item.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.facebook_feed_rv_item, parent, false);
        return new FacebookFeedRVAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FacebookFeedRVAdapter.ViewHolder holder, int position) {
        //getting data from arraylist and setting it to our modal class.
        FacebookFeedModal modal = facebookFeedModalArrayList.get(position);
        //settting data to each view of recyclerview item.
        Picasso.get().load(modal.getAuthorImage()).into(holder.authorIV);
        holder.authorNameTV.setText(modal.getAuthorName());
        holder.timeTV.setText(modal.getPostDate());
        holder.descTV.setText(modal.getPostDescription());
        Picasso.get().load(modal.getPostIV()).into(holder.postIV);
        holder.likesTV.setText(modal.getPostLikes());
        holder.commentsTV.setText(modal.getPostComments());

    }

    @Override
    public int getItemCount() {
        //returning the size of our array list.
        return facebookFeedModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //creating variables for our views of recycler view items.
        private CircleImageView authorIV;
        private TextView authorNameTV, timeTV, descTV;
        private ImageView postIV;
        private TextView likesTV, commentsTV;
        private LinearLayout shareLL;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //initializing our variables
            shareLL = itemView.findViewById(R.id.idLLShare);
            authorIV = itemView.findViewById(R.id.idCVAuthor);
            authorNameTV = itemView.findViewById(R.id.idTVAuthorName);
            timeTV = itemView.findViewById(R.id.idTVTime);
            descTV = itemView.findViewById(R.id.idTVDescription);
            postIV = itemView.findViewById(R.id.idIVPost);
            likesTV = itemView.findViewById(R.id.idTVLikes);
            commentsTV = itemView.findViewById(R.id.idTVComments);
        }
    }
}
