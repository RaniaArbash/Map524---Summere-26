package com.example.week3;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Student implements Parcelable {

    String name;
    int yob;
    String collegeName;

    //Bitmap std_img;// this is not primitive type so can't be parcelable
    public Student(String name, int yob, String collegeName) {
        this.name = name;
        this.yob = yob;
        this.collegeName = collegeName;
    }

    protected Student(Parcel in) {
        name = in.readString();
        yob = in.readInt();
        collegeName = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(yob);
        dest.writeString(collegeName);
    }
}
