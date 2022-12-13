package it.mirea.pizzeria.vk;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import it.mirea.pizzeria.DBProfile;

public class VkViewModel extends AndroidViewModel {

    private final VkRepository vkRepository;

    public VkViewModel(@NonNull Application application) {
        super(application);
        vkRepository = new VkRepository();
    }

    public LiveData<DBProfile> getUsernameVk(String token, String userId) {
        return vkRepository.getInfoProfile(token, userId);
    }
}