package com.example.listviewtest;

/**
 * Created by Administrator on 2017/5/25 0025.
 */

public class Fruit {
    private  String name;
    private  int imageId;
    public Fruit(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
