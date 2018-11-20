package com.jovanyguiagmail.networkcodelabs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private Post[] posts = new Post[0];

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PostViewHolder extends RecyclerView.ViewHolder{

        ImageView postImage;
        TextView postName;
        TextView postMessage;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            postImage = itemView.findViewById(R.id.post_image);
            postName = itemView.findViewById(R.id.post_name);
            postMessage = itemView.findViewById(R.id.post_text);
        }
    }
}
