package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements RecyclerViewAdapter.TaskUpdatingListener{
RecyclerView todolist;
ArrayList<ToDo> listOfTasks = new ArrayList<>(0);
FloatingActionButton addNewTodoButton;
    private ActivityResultLauncher<Intent> myLauncher;
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        todolist = findViewById(R.id.todolist);
        adapter = new RecyclerViewAdapter(listOfTasks);
        adapter.listener = this;
        todolist.setAdapter(adapter);
        todolist.setLayoutManager(new LinearLayoutManager(this));

        myLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                       ToDo newToDo = result.getData().getExtras().getSerializable("newtodo",ToDo.class);
                        listOfTasks.add(newToDo);
                       // adapter.notifyDataSetChanged();
                       adapter.notifyItemInserted(listOfTasks.size()-1);
                    }
                });

        addNewTodoButton = findViewById(R.id.addNewToDo);
        addNewTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddNewToDoIntent = new Intent(MainActivity.this,AddNewToDoActivity.class);
                //startActivity(cameraIntent);
                myLauncher.launch(AddNewToDoIntent);
            }
        });
    }

    @Override
    public void taskUpdated(int position) {
        listOfTasks.get(position).isUrgent = !listOfTasks.get(position).isUrgent;
        adapter.notifyItemChanged(position);

    }
}