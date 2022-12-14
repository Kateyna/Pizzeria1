package it.mirea.pizzeria;
import android.content.Context;

import  androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

@Database(entities = {Pizza.class, DBProfile.class},version = 1)
    public abstract class PizzaDatabase extends RoomDatabase {
    public static SupportSQLiteStatement databaseWriteExecutor;


    public abstract PizzaDAO pizzaDAO();
    public abstract ProfileDAO getProfileDao();

    private static volatile  PizzaDatabase INSTANCE;
    public  static  PizzaDatabase getDatabase (Context context){
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
