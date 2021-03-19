package com.creativehub.petspot.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category{
    public Category(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    @ColumnInfo(name = "image_url")
    public String imageUrl;
}

