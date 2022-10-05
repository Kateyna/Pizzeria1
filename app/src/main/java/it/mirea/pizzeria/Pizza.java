package it.mirea.pizzeria;

import android.app.Person;

import org.jetbrains.annotations.NotNull;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pizza {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name" )
    public String name;

    @ColumnInfo(name = "pizza_name" )
    public String pizza_name;

    @ColumnInfo(name = "recept")
    public String recept;



    public Pizza(String name, String pizza_name, String recept){
        this.pizza_name = pizza_name;
        this.name = name;
        this.recept = recept;

    }







}
