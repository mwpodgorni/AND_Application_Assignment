package com.example.myproject.Stories;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myproject.R;

public class StartStoryActivity extends AppCompatActivity {
    private ImageView titleImageView;
    private EditText nameField;
    private Button startButton;
    private int storyNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_story);
        titleImageView=(ImageView)findViewById(R.id.titleImageView);
        nameField =(EditText)findViewById(R.id.nameField);
        startButton=(Button)findViewById(R.id.startButton);
        //getting chosen story
        titleImageView.setImageResource(getIntent().getIntExtra("titleImg", R.drawable.s1));
        storyNumber= getIntent().getIntExtra("storyNumber", 0);
        //starting story
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                startStory(name);
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        nameField.setText("");
    }
    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources= getResources();
        String key = resources.getString(R.string.key_name);
        intent.putExtra(key, name);
        intent.putExtra("storyNumber", storyNumber);
        startActivity(intent);
    }
}
