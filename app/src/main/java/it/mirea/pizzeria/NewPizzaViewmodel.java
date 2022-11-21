package it.mirea.pizzeria;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import io.github.cdimascio.dotenv.Dotenv;

public class NewPizzaViewmodel extends AndroidViewModel {
    private LiveData<List<countries>> detailApiResponceMutableLiveData;
    private PizzaAddressAnalysis mIssueRepository;
    // No argument constructor
    public NewPizzaViewmodel(@NonNull Application application) {
        super(application);


    }

    public void init() {
        mIssueRepository = new PizzaAddressAnalysis();
        detailApiResponceMutableLiveData = mIssueRepository.getVolumesResponseLiveData();
    }





    public LiveData<List<countries>> getVolumesResponseLiveData() {
        return detailApiResponceMutableLiveData;
    }
}



