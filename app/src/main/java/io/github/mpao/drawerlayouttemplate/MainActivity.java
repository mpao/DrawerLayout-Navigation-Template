/*
 * Copyright 2018, Marco Paoletti <mpao@me.com>, http://mpao.github.io
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.mpao.drawerlayouttemplate;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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
            getFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
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
        getFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
    //endregion

}
