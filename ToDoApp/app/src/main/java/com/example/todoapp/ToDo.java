package com.example.todoapp;

import java.util.Date;

public class ToDo {
    String task;
    Date date_time;
    Boolean isUrgent;

    public ToDo(String task, Date date_time, Boolean isUrgent) {
        this.task = task;
        this.date_time = date_time;
        this.isUrgent = isUrgent;
    }
}
