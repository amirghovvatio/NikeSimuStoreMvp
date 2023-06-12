package com.example.stormvpgit.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "_shoes")
public class Shoes implements Parcelable {
//
//    @PrimaryKey(autoGenerate = true)
    @PrimaryKey(autoGenerate = false)
    private int id;


    private String name;
    private int price;
    private int res;
    private String color;
    private String size;
    public Shoes(){}
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Shoes(int id, String name, int price, int res) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.res = res;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.price);
        dest.writeInt(this.res);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.name = source.readString();
        this.price = source.readInt();
        this.res = source.readInt();
    }

    protected Shoes(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.price = in.readInt();
        this.res = in.readInt();
    }

    public static final Creator<Shoes> CREATOR = new Creator<Shoes>() {
        @Override
        public Shoes createFromParcel(Parcel source) {
            return new Shoes(source);
        }

        @Override
        public Shoes[] newArray(int size) {
            return new Shoes[size];
        }
    };
}
