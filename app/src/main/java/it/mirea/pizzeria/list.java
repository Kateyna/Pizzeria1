package it.mirea.pizzeria;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class list {
    //private int id;

    // @SerializedName("name")
    // @Expose
    //  @ColumnInfo(name = "name")
    //  private String name;


    // @SerializedName("price")
    // @Expose
    // @ColumnInfo(name = "price")
    // private int price;

    // @SerializedName("description")
    // @Expose
    // @ColumnInfo(name = "description")
    // private String description;


    // @SerializedName("veg")
    //  @Expose
    //  @ColumnInfo(name = "veg")
    //  private boolean veg;



    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("code")
    @Expose
    private String code;


    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("currency")
    @Expose
    private String currency;




    // public drinks(String name, int price, String description, String strDrinkThumb, boolean veg){
    //     this.strDrinkThumb = strDrinkThumb;
    //     this.name = name;
    //      this.price = price;
    //      this.description = description;
    //      this.veg = veg;

    //  }


    //  public int getId() {
    //      return id;
    //  }

    //  public String getName() {
    //      return name;
    //  }

    //  public boolean getVeg() {
    //      return veg;
    //  }


    //   public int getPrice() {
    //       return price;
    //   }

    //  public String getDescription() {
    //      return description;
    //  }

    public int getId2(){
        return id;
    }
    public String getCode() {
        return code;
    }

    public String getCurrency() {
        return currency;
    }

    public String getName2() {
        return currency;
    }




}
