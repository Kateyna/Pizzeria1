package it.mirea.pizzeria;

import android.app.Person;



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
    public long uid;

    @ColumnInfo(name = "name" )
    public String namei;

    @ColumnInfo(name = "pizza_name" )
    public String pizza_name;

    @ColumnInfo(name = "recept")
    public String recept;



    public Pizza(long uid,String namei, String pizza_name, String recept){
        this.uid = uid;
        this.pizza_name = pizza_name;
        this.namei = namei;
        this.recept = recept;

    }
    public long getUid(){return uid;}

    public void setUid(long uid){this.uid = uid;}

    public String getPizza_name() {
        return pizza_name;
    }



    public void setPizza_name(String pizza_name) {
        this.pizza_name = pizza_name;
    }

    public String getNamei() {
        return namei;
    }

    public void setName(String name) {
        this.namei = name;
    }

    public String getRecept() {
        return recept;
    }

    public void setRecept(String recept) {
        this.recept = recept;
    }



}
