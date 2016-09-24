package br.com.fiap.petwell.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.petwell.initalizer.AppNavInitializer;
import br.com.fiap.petwell.layout.adapter.SlidingMenuAdapter;
import br.com.fiap.petwell.layout.fragment.Fragment1;
import br.com.fiap.petwell.layout.fragment.Fragment2;
import br.com.fiap.petwell.layout.fragment.Fragment3;
import br.com.fiap.petwell.layout.model.ItemSlideMenu;
import br.com.fiap.petwell.requesttask.FeederRegisterRequestTask;
import br.com.fiap.petwell.requesttask.LoginRequestTask;
import br.com.fiap.petwell.requesttask.LogoutRequestTask;
import br.com.fiap.petwell.util.hash.HashUtil;

public class AppNavActivity extends AppCompatActivity {

    private AppNavInitializer initializer;
    private SharedPreferences sharedPreferences;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appnav);

        initializer = new AppNavInitializer(this);

        sharedPreferences = this.getSharedPreferences("Hash", Context.MODE_PRIVATE);
        String hash = sharedPreferences.getString("Hash", "NO_HASH_FOUND");
        if (hash.equals("NO_HASH_FOUND")){
            Intent toLoginAct = new Intent (this, LoginActivity.class);
            startActivity(toLoginAct);
        }

        initializer.componentInitializer();

        initializer.addItemToSliding();

        //Display icon to open/close sliding list_item_style
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializer.setTitle();
        initializer.itemSelected();
        initializer.closeMenu();

        initializer.replaceFragment(0);

        initializer.handleOnItemClick();

        initializer.actionBarToggle();

        initializer.addDrawerListener();

    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }


    public void logout(View v){
        LogoutRequestTask logoutRequestTask = new LogoutRequestTask(this);
        logoutRequestTask.execute();
    }

    public void registerFeeder(View v){
        String feederName = ((EditText) findViewById(R.id.edtFeederName)).getText().toString();
        int devCode = Integer.parseInt(((EditText) findViewById(R.id.edtDevCode)).getText().toString());
        FeederRegisterRequestTask feederRegisterRequestTask = new FeederRegisterRequestTask(this, feederName, devCode);
    }
}
