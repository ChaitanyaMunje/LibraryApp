package com.gtappdevelopers.instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class InstaAdapter extends  RecyclerView.Adapter<InstaAdapter.InstaViewHolder>  {

    private ArrayList<InstaFeedModal> instaFeedModalArrayList;
    private Context mcontext;

    public InstaAdapter(ArrayList<InstaFeedModal> instaFeedModalArrayList, Context mcontext) {
        this.instaFeedModalArrayList = instaFeedModalArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public InstaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating our layout for item of recycler view item.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.insta_feed_rv_item, parent, false);
        return new InstaAdapter.InstaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstaViewHolder holder, int position) {

        //inside on bind view holder method we are setting ou data to each UI component.
        InstaFeedModal instaFeedModal = instaFeedModalArrayList.get(position);
        Picasso.get().load(instaFeedModal.getAuthorImageUrl()).into(holder.authorIV);
        holder.authorTV.setText(instaFeedModal.getAuthorName());
        Picasso.get().load(instaFeedModal.getPostImgUrl()).into(holder.postIV);
        holder.likeTV.setText(""+instaFeedModal.getLikeCount()+" likes");
        holder.desctv.setText(instaFeedModal.getPostDescription());

    }

    @Override
    public int getItemCount() {
        return instaFeedModalArrayList.size();
    }

    public class InstaViewHolder extends RecyclerView.ViewHolder {

        CircleImageView authorIV;
        private TextView authorTV;
        private ImageView postIV;
        private TextView likeTV,desctv;


        public InstaViewHolder(@NonNull View itemView) {
            super(itemView);
            authorIV = itemView.findViewById(R.id.idCVAuthor);
            authorTV = itemView.findViewById(R.id.idTVAuthorName);
            postIV = itemView.findViewById(R.id.idIVPost);
            likeTV = itemView.findViewById(R.id.idTVLikes);
            desctv = itemView.findViewById(R.id.idTVPostDesc);

        }
    }
}
