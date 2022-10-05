package it.mirea.pizzeria;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;

public class PizzaRepozitory{

    PizzaDAO pizzaDAO;

    PizzaRepozitory(Application application){
        PizzaDatabase db = PizzaDatabase.getDatabase(application);
        pizzaDAO = db.pizzaDAO();
    }

    LiveData<List<Pizza>> getPizza(){
        return  pizzaDAO.getAllPizzas();

    }

    void  insert(Pizza pizza){
        new insertAsyncTask(pizzaDAO).execute(pizza);
    }

    private static class insertAsyncTask extends AsyncTask<Pizza,Void,Void>{
        private  PizzaDAO taskDao;

        insertAsyncTask(PizzaDAO pizzaDAO){
            taskDao = pizzaDAO;
        }
        @Override
        protected Void doInBackground(Pizza... pizzas){

            taskDao.insertAll(pizzas[0]);
            return null;
        }

    }
}
