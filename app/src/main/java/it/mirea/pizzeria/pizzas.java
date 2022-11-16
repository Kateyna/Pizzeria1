package it.mirea.pizzeria;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class pizzas {
    private int id;

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    private String name;


    @SerializedName("price")
    @Expose
    @ColumnInfo(name = "price")
    private int price;

    @SerializedName("description")
    @Expose
    @ColumnInfo(name = "description")
    private String description;


    @SerializedName("veg")
    @Expose
    @ColumnInfo(name = "veg")
    private boolean veg;


    @SerializedName("img")
    @Expose
    @ColumnInfo(name = "img")
    private String img;

    @SerializedName("pizzas")
    @Expose
    List<pizzas> oli = null;

    public pizzas(String name, int price, String description,String img, boolean veg){
        this.img = img;
        this.name = name;
        this.price = price;
        this.description = description;
        this.veg = veg;

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getVeg() {
        return veg;
    }

    public List <pizzas> getItems(){
        return oli;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }
}
