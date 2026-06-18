package com.example.todoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.ToDoViewHolder>{

    ArrayList<ToDo> todoList;
    Context context;

    public RecyclerViewAdapter(ArrayList<ToDo> todoList, Context context) {
        this.todoList = todoList;
        this.context = context;
    }

    // inner class
    class ToDoViewHolder extends RecyclerView.ViewHolder{
        private final TextView taskName;
        private final TextView taskDate;
        private final Switch urgentSwitch;
        public ToDoViewHolder(@NonNull View view) {
            super(view);
            taskName = (TextView) view.findViewById(R.id.rtaskname);
            taskDate = view.findViewById(R.id.rtaskdate);
            urgentSwitch = view.findViewById(R.id.rurgency_update);
        }
        public TextView getTaskName() {
            return taskName;
        }

        public TextView getTaskDate() {
            return taskDate;
        }

        public Switch getUrgentSwitch() {
            return urgentSwitch;
        }
    }


    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.todo_row_layout,parent,false);
        return new ToDoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDo item = todoList.get(position);
        holder.taskName.setText(item.task);
        holder.taskDate.setText(item.date_time.toString());
        holder.urgentSwitch.setChecked(item.isUrgent);

        if (item.isUrgent)
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.red));
        else
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.green));

    }


    @Override
    public int getItemCount() {
        return todoList.size();
    }
}
