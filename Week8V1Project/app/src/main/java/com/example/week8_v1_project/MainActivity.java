package com.example.week8_v1_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    EditText etName, etAge;
    Button btnShow;
    LinearLayout profileCard;
    TextView tvName, tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnShow = findViewById(R.id.btnShow);
        profileCard = findViewById(R.id.profileCard);
        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();
                String age = etAge.getText().toString();

                if (!name.isEmpty() && !age.isEmpty()) {

                    tvName.setText("Name: " + name);
                    tvAge.setText("Age: " + age);

                    profileCard.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
