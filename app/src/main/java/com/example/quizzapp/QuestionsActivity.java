package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QuestionsActivity extends AppCompatActivity {

//    TextView category_name;
    ImageView category_image;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

//        category_name=findViewById(R.id.Category);
        category_image=findViewById(R.id.Imagecategory);

        Intent intent= getIntent();
//        category_name.setText(intent.getStringExtra("Category Name"));
        category_image.setImageResource(intent.getIntExtra("Category Image",R.drawable.artandliterature));

        start= (Button) findViewById(R.id.startQuiz);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz();
            }
        });
    }

    private void startQuiz(){

    }

}