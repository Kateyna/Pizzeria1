package it.mirea.pizzeria;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PizzaRepository {

    private PizzaDAO mPizzaDao;
    private LiveData<List<Pizza>> mAllPizzas ;

    public PizzaRepository(Application application){
        PizzaDatabase db = PizzaDatabase.getDatabase(application);
        mPizzaDao = db.pizzaDAO();
        mAllPizzas = mPizzaDao.getAllPizzasLive();
    }

    public void insert(Pizza pizza){
        new InsertPizzasAsyncTask(mPizzaDao).execute(pizza);
    }

    public void update(Pizza pizza){
        new UpdatePizzasAsyncTask(mPizzaDao).execute(pizza);
    }

    public void delete(Pizza pizza){
        new DeletePizzasAsyncTask(mPizzaDao).execute(pizza);
    }

    public LiveData<List<Pizza>> getAllPizzas(){
        return mAllPizzas;
    }

    private static class InsertPizzasAsyncTask extends AsyncTask<Pizza, Void, Void>{
        private PizzaDAO pizzaDAO;
        private InsertPizzasAsyncTask(PizzaDAO pizzaDAO){
            this.pizzaDAO = pizzaDAO;
        }

        @Override
        protected Void doInBackground(Pizza... pizzas) {
            pizzaDAO.AddPizza(pizzas[0]);
            return null;
        }
    }

    private static class UpdatePizzasAsyncTask extends AsyncTask<Pizza, Void, Void>{
        private PizzaDAO pizzaDAO;
        private UpdatePizzasAsyncTask(PizzaDAO pizzaDAO){
            this.pizzaDAO = pizzaDAO;
        }

        @Override
        protected Void doInBackground(Pizza... pizzas) {
            pizzaDAO.UpdatePizza(pizzas[0]);
            return null;
        }
    }

    private static class DeletePizzasAsyncTask extends AsyncTask<Pizza, Void, Void>{
        private PizzaDAO pizzaDAO;
        private DeletePizzasAsyncTask(PizzaDAO pizzaDAO){
            this.pizzaDAO = pizzaDAO;
        }

        @Override
        protected Void doInBackground(Pizza... pizzas) {
            pizzaDAO.DeletePizza(pizzas[0]);
            return null;
        }
    }


}