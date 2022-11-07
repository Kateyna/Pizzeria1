package it.mirea.pizzeria;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailApiResponce {
    private int id;
    @SerializedName("body")
    private String name;
    private boolean veg;
    private int price;
    private String description;
    private String img;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isVeg() {
        return veg;
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
