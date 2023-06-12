package com.example.stormvpgit.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "_favorite")
public class Favorite {
    @PrimaryKey(autoGenerate = true)
    private int favId;
    private String name;
    private int price;
    private int res;
    private String color;
    private String size;

    public int getFavId() {
        return favId;
    }

    public void setFavId(int favId) {
        this.favId = favId;
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
}
