package it.mirea.pizzeria.vk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import it.mirea.pizzeria.AuthActivity;
import it.mirea.pizzeria.ConfigUser;
import it.mirea.pizzeria.DBProfile;
import it.mirea.pizzeria.ProfileViewModel;
import it.mirea.pizzeria.R;
import it.mirea.pizzeria.SignInFragment;
import it.mirea.pizzeria.databinding.FragmentVkBinding;
import it.mirea.pizzeria.databinding.FragmentVkSignUpBinding;
import it.mirea.pizzeria.databinding.RegistrationActivityBinding;

public class VkSignUpFragment extends Fragment {

    FragmentVkSignUpBinding binding;
    VkViewModel model;
    ProfileViewModel pModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentVkSignUpBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        model = new ViewModelProvider(this).get(VkViewModel.class);
        pModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        pModel.getAllProfile().observe(getViewLifecycleOwner(), new Observer<List<DBProfile>>() {
            @Override
            public void onChanged(List<DBProfile> dbProfiles) {
                if (dbProfiles == null){
                    AuthActivity.maxID = 1;
                }else {
                    AuthActivity.maxID = dbProfiles.size();
                }
            }
        });

        DBProfile data = new DBProfile();
        model.getUsernameVk(ConfigUser.getInstance().access_token, ConfigUser.getInstance().user_id).observe(getViewLifecycleOwner(), new Observer<DBProfile>() {
            @Override
            public void onChanged(DBProfile profile) {
                data.setName(profile.getName());
                data.setUsername(profile.getUsername());
                data.setEmail(ConfigUser.getInstance().email);

                System.out.println(profile.getEmail());

            }
        });

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pModel.insertProfile(new DBProfile(0, data.getUsername(), data.getEmail(), "",data.getName(),"user"));
                replaceFragment(new SignInFragment());
            }
        });

    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.authFrame, fragment);
        ft.commit();
    }
}