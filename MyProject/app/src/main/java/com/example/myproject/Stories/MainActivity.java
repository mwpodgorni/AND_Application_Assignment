package com.example.myproject.Stories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myproject.R;
import com.example.myproject.Stories.model.Stories;

public class MainActivity extends AppCompatActivity implements StoryAdapter.OnListItemClickListener {
    RecyclerView mStoryList;
    RecyclerView.Adapter mStoryAdapter;
    Stories stories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stories= new Stories();
        mStoryList = findViewById(R.id.rv);
        mStoryList.hasFixedSize();
        mStoryList.setLayoutManager(new LinearLayoutManager(this));
        mStoryAdapter = new StoryAdapter(stories, this);
        mStoryList.setAdapter(mStoryAdapter);
    }
    @Override
    public void onListItemClick(int clickedItemIndex) {
        //Toast.makeText(this, "Story Number: " + storyNumber, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, StartStoryActivity.class);

        intent.putExtra("titleImg", stories.getStory(clickedItemIndex).getIconId());
        intent.putExtra("storyNumber", clickedItemIndex);
        startActivity(intent);
    }
}
