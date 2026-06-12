package com.example.week3;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class StudentInfoActivity extends AppCompatActivity {

    ImageView stdphoto;
    Button openCameraButton;
    Button web_search_Button;
    EditText query_text;

    private ActivityResultLauncher<Intent> myLauncher;

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","Student Activity - On Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","Student Activity - On Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","Student Activity - On Restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","Student Activity - On Stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","Student Activity - On Start");
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Log.d("lifecycle","Student Activity - On Create");

        setContentView(R.layout.activity_student_info);
        Student selectedStd =  Objects.requireNonNull(getIntent().getExtras()).getParcelable("selectedStudent");

        myLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bitmap thumbnail = result.getData().getParcelableExtra("data", Bitmap.class);
                       stdphoto.setImageBitmap(thumbnail);
                      // selectedStd.std_img = thumbnail;
                        assert selectedStd != null;
                        StudentService.shared.updateStdImage(thumbnail,selectedStd);
                    }
                });

        openCameraButton =  findViewById(R.id.camera_button);
        stdphoto = findViewById(R.id.std_photo);
        web_search_Button = findViewById(R.id.web_search_button);
        query_text = findViewById(R.id.web_search_text);

        openCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivity(cameraIntent);
                myLauncher.launch(cameraIntent);
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
