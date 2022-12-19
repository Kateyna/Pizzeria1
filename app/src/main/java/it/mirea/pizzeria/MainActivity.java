package it.mirea.pizzeria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;
import it.mirea.pizzeria.DBProfile;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import it.mirea.pizzeria.databinding.ActivityMainBinding;
import it.mirea.pizzeria.ui.dashboard.DashboardFragment;
import it.mirea.pizzeria.ui.home.HomeFragment;
import it.mirea.pizzeria.ui.notifications.NotificationsFragment;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    EditText Pizzaname;
    EditText Receptpizza;
    EditText Name;
    PizzaViewmodel model;
    ProfileViewModel profileViewModel;
    Button button;
    public static long user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        model = new ViewModelProvider(this).get(PizzaViewmodel.class);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        profileViewModel.getProfile(user_id).observeForever(new Observer<DBProfile>() {
            @Override
            public void onChanged(DBProfile profile) {
                if(profile.getPermission().equals("user")){
                    binding.bottomNavMenu.setVisibility(View.VISIBLE);
                    binding.bottomNavMenuAdmin.setVisibility(View.GONE);
                    binding.bottomNavMenuModer.setVisibility(View.GONE);
                    binding.bottomNavMenu.setSelectedItemId(R.id.navigation_home);
                    binding.bottomNavMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.navigation_home:
                                    replaceFragment(new HomeFragment());
                                    break;
                                case R.id.navigation_dashboard:
                                    replaceFragment(new DashboardFragment());
                                    break;
                                case R.id.navigation_notifications:
                                    replaceFragment(new NotificationsFragment());
                                    break;
                            }
                            return true;
                        }
                    });
                }else if (profile.getPermission().equals("admin")){
                    binding.bottomNavMenu.setVisibility(View.GONE);
                    binding.bottomNavMenuAdmin.setVisibility(View.VISIBLE);
                    binding.bottomNavMenuModer.setVisibility(View.GONE);
                    binding.bottomNavMenuAdmin.setSelectedItemId(R.id.navigation_home);
                    binding.bottomNavMenuAdmin.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.navigation_home:
                                    replaceFragment(new HomeFragment());
                                    break;
                                case R.id.navigation_dashboard:
                                    replaceFragment(new PizzaListPermFragment());
                                    break;
                                case R.id.navigation_notifications:
                                    replaceFragment(new NotificationsFragment());
                                    break;
                                case R.id.navigation_person:
                                    replaceFragment(new PermsFragment());
                                    break;
                            }
                            return true;
                        }
                    });
                }else if(profile.getPermission().equals("moder")){
                    binding.bottomNavMenu.setVisibility(View.GONE);
                    binding.bottomNavMenuAdmin.setVisibility(View.GONE);
                    binding.bottomNavMenuModer.setVisibility(View.VISIBLE);
                    binding.bottomNavMenuModer.setSelectedItemId(R.id.navigation_home);
                    binding.bottomNavMenuModer.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.navigation_home:
                                    replaceFragment(new HomeFragment());
                                    break;
                                case R.id.navigation_dashboard:
                                    replaceFragment(new PizzaListPermFragment());
                                    break;
                            }
                            return true;
                        }
                    });
                }
            }
        });

        replaceFragment(new HomeFragment());


    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        ft.replace(R.id.mainFrame, fragment);
        ft.commit();
    }
}