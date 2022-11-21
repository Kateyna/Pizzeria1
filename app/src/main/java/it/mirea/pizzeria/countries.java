package it.mirea.pizzeria;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class countries {
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




    private int id;

    private String code;

    private String name;

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
        return name;
    }




}
