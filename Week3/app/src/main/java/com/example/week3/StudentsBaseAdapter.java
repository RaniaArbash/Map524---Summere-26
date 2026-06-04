package com.example.week3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentsBaseAdapter extends BaseAdapter {
    // I have a list of students
    // I need access to the layouts in runtime ==> this means context
    ArrayList<Student> list;
    Context context;

    public StudentsBaseAdapter(ArrayList<Student> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {// number of students- base adapter has to display
        return list.size();
    }

    @Override
    public Object getItem(int position) {// return one student as object
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {// index of student in the list
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row_view = LayoutInflater.from(context).inflate(R.layout.listview_row, parent,false);
        TextView nametxt = row_view.findViewById(R.id.std_list_stdName);
        TextView yobtxt = row_view.findViewById(R.id.yob);
        TextView collegetxt = row_view.findViewById(R.id.std_list_collegeName);

        int y =  list.get(position).yob;
       // y.toString();

        nametxt.setText(list.get(position).name);
        yobtxt.setText(""+list.get(position).yob);
        collegetxt.setText(list.get(position).collegeName);

        return row_view;
    }
}
