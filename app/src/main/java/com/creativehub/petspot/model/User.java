package com.creativehub.petspot.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "last_name")
    public String lastName;
    public String email;
    public String password;
    @ColumnInfo(name = "repeat_password")
    public String repeatPassword;
    @ColumnInfo(name = "city_id")
    public int cityId;
    @ColumnInfo(name = "phone_number")
    public String phoneNumber;
}
