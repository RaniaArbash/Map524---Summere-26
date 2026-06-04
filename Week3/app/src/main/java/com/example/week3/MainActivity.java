package com.example.week3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText std_name_text;
    Spinner yob_spinner;
    Spinner college_spinner;
    Button save_button;
    ListView std_table;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        std_name_text = findViewById(R.id.studentName);
        yob_spinner = findViewById(R.id.yob);
        college_spinner = findViewById(R.id.collegeName);
        save_button = findViewById(R.id.save_std);
        std_table = findViewById(R.id.listview);

        StudentsBaseAdapter adapter = new StudentsBaseAdapter(StudentService.shared.list, this);
        std_table.setAdapter(adapter);
        std_table.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selected Student' name "+ StudentService.shared.list.get(position).name +" Year of birth " +StudentService.shared.list.get(position).yob,
                        Toast.LENGTH_SHORT).show();
                Intent goToDetailsIntent = new Intent(MainActivity.this,StudentInfoActivity.class );
                startActivity(goToDetailsIntent);
            }
        });

        String[] listOfColleges = new String[]{
                "Seneca College",
                "Humber College",
                "Centennial College"
        };

        String [] yob = new String[]{
                "2000",
                "2001",
                "2002",
                "2003",
                "2004",
                "2005",
                "2006",
                "2007",
        };

        ArrayAdapter collegeAdapter = new ArrayAdapter(this,
                R.layout.spinner_row,
                R.id.spinner_college_text,
                listOfColleges);

        college_spinner.setAdapter(collegeAdapter);// spinner and adapter connection

        ArrayAdapter yobAdapter = new ArrayAdapter(this,
                R.layout.spinner_row,
                R.id.spinner_college_text,
                yob
                );
        yob_spinner.setAdapter(yobAdapter);


        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!std_name_text.getText().isEmpty()){
                    String name = std_name_text.getText().toString();
                    int yob = Integer.parseInt( yob_spinner.getSelectedItem().toString());
                    String selectedCollege = college_spinner.getSelectedItem().toString();

                       StudentService.shared.saveNewStudent(
                             name,
                               yob,
                               selectedCollege
                               );
                    adapter.notifyDataSetChanged();// very important

                    std_name_text.setText("");
                    yob_spinner.setSelection(0);
                    college_spinner.setSelection(0);

                }
            }
        });



    }


}