package it.mirea.pizzeria;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.github.cdimascio.dotenv.Dotenv;

@HiltViewModel
public class NewPizzaViewmodel extends ViewModel {
    MutableLiveData<List<RecyclerData>> liveData;

    @Inject
    RetroServiceInterface retroServiceInterface;

    @Inject
    public NewPizzaViewmodel() {
        liveData = new MutableLiveData();
    }

    public MutableLiveData<List<RecyclerData>> getLiveData() {
        return liveData;
    }

    public void makeApiCall() {
        RetroRepository retroRepository = new RetroRepository(retroServiceInterface);
        retroRepository.makeAPICall("pizza", liveData);
    }
}


