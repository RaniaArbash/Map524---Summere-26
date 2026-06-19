package com.example.todoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.ToDoViewHolder>{


    interface TaskUpdatingListener {
        void taskUpdated(int position);
    }

    TaskUpdatingListener listener;
    ArrayList<ToDo> todoList;
    //Context context;

    public RecyclerViewAdapter(ArrayList<ToDo> todoList) {
        this.todoList = todoList;
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_row_layout,parent,false);
        return new ToDoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDo item = todoList.get(position);
        holder.taskName.setText(item.task);
        holder.taskDate.setText(item.date_time.toString());
        holder.urgentSwitch.setChecked(item.isUrgent);

        if (item.isUrgent)
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.red));
        else
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.green));

        holder.urgentSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // will notify when the switch clicked
                // MainActivity can update the task
                ///  here now way to update the task
                int index = holder.getBindingAdapterPosition();
                listener.taskUpdated(index);


            }
        });


    }


    @Override
    public int getItemCount() {
        return todoList.size();
    }// 10
}
