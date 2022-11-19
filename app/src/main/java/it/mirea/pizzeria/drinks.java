package it.mirea.pizzeria;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class drinks {
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


    @SerializedName("strDrinkThumb")
    @Expose
    @ColumnInfo(name = "strDrinkThumb")
    private String strDrinkThumb;

    @SerializedName("strDrink")
    @Expose
    @ColumnInfo(name = "strDrink")
    private String strDrink;


    @SerializedName("drinks")
    @Expose
    List<drinks> oli = null;

   // public drinks(String name, int price, String description, String strDrinkThumb, boolean veg){
   //     this.strDrinkThumb = strDrinkThumb;
   //     this.name = name;
  //      this.price = price;
  //      this.description = description;
  //      this.veg = veg;

  //  }

    public drinks(String strDrinkThumb){
        this.strDrinkThumb = strDrinkThumb;
    }


  //  public int getId() {
  //      return id;
  //  }

  //  public String getName() {
  //      return name;
  //  }

  //  public boolean getVeg() {
  //      return veg;
  //  }

    public List <drinks> getItems(){
        return oli;
    }

 //   public int getPrice() {
 //       return price;
 //   }

  //  public String getDescription() {
  //      return description;
  //  }
    public String getStrDrink(){
        return strDrink;
    }

    public String getImg() {
        return strDrinkThumb;
    }
}
