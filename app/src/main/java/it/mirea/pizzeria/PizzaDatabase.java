package it.mirea.pizzeria;
import android.content.Context;

import  androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Pizza.class},version = 1)
public abstract class PizzaDatabase extends RoomDatabase {
    public abstract PizzaDAO pizzaDAO();

    public  static  PizzaDatabase INSTANCE;

    public  static  PizzaDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (PizzaDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PizzaDatabase.class, "pizza-database").fallbackToDestructiveMigration().build();

                }
            }
        }

        return INSTANCE;

    }


}
