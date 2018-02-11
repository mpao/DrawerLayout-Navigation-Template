package io.github.mpao.drawerlayouttemplate.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import io.github.mpao.drawerlayouttemplate.R;
import io.github.mpao.drawerlayouttemplate.databinding.MainActivityBinding;
import io.github.mpao.drawerlayouttemplate.databinding.NavHeaderBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private MainActivityBinding binding;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        NavHeaderBinding navHeaderBinding = DataBindingUtil.bind( binding.navView.getHeaderView(0));
        assert binding.content != null;
        setSupportActionBar( binding.content.toolbar );

        // hamburger toogle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.content.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // initialize stuff
        navHeaderBinding.username.setText("Marco Paoletti");
        navHeaderBinding.userinfo.setText("Descrizione per l'utente");
        binding.navView.setNavigationItemSelectedListener(this);
        if( savedInstanceState == null) {
            fragment = new NewsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
        }
    }

    //region Activity Navigation
    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            // metto app in background, senza fare pop di nulla;
            // in questo modo se esco con tasto back, la app si ripresenta con
            // il fragment con cui l'ho lasciata
            moveTaskToBack (true);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        String title = getString(R.string.app_name);

        switch ( item.getItemId() ){

            case R.id.nav_gallery :
                fragment = new NewsFragment();
                title = "Home";
                break;
            case R.id.nav_slideshow :
                fragment = new PlaceHolderFragment();
                title = "Primo";
                break;
            case R.id.nav_manage :
                fragment = new PlaceHolderFragment();
                title = "Secondo";
                break;
            case R.id.nav_share :
                fragment = new PlaceHolderFragment();
                title = "Terzo";
                break;

        }

        assert binding.content != null;
        binding.content.toolbar.setTitle(title);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
    //endregion

}
