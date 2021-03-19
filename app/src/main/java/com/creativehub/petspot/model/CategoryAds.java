package com.creativehub.petspot.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CategoryAds {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name = "Igor";
    @ColumnInfo(name = "phone_number")
    public String phoneNumber = "070204584";
    public String city = "Skopje";
    public String description = "Шетам Кучиња";
}
