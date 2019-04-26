package com.example.myproject.Stories;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myproject.R;
import com.example.myproject.Stories.model.Stories;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    private Stories mStories;
    final private OnListItemClickListener mOnListItemClickListener;

    StoryAdapter(Stories stories, OnListItemClickListener listener){
        mStories = stories;
        mOnListItemClickListener = listener;
    }
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.story_list_item, parent, false);
        return new ViewHolder(view);
    }
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name.setText(mStories.getStory(position).getName());
        viewHolder.icon.setImageResource(mStories.getStory(position).getIconId());
    }
    public int getItemCount() {
        return mStories.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        ImageView icon;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            icon = itemView.findViewById(R.id.iv_icon);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }
    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
