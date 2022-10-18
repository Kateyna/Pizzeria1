package it.mirea.pizzeria;

import android.app.Person;

import org.jetbrains.annotations.NotNull;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
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
    public String getPizza_name() {
        return pizza_name;
    }

    public void setPizza_name(String pizza_name) {
        this.pizza_name = pizza_name;
    }

    public String getName() {
        return name;
    }

    public void getName(String name) {
        this.name = name;
    }

    public String getRecept() {
        return recept;
    }

    public void setRecept(String recept) {
        this.recept = recept;
    }



}
