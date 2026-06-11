package com.example.week3;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class StudentInfoActivity extends AppCompatActivity {

    ImageView stdphoto;
    Button openCameraButton;
    Button web_search_Button;
    EditText query_text;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_info);
        Student selectedStd =  Objects.requireNonNull(getIntent().getExtras()).getParcelable("selectedStudent");

        openCameraButton =  findViewById(R.id.camera_button);
        stdphoto = findViewById(R.id.std_photo);
        web_search_Button = findViewById(R.id.web_search_button);
        query_text = findViewById(R.id.web_search_text);

        openCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
            }
        });

        web_search_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, query_text.getText().toString());
                startActivity(intent);


            }
        });



    }
}
