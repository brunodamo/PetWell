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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.petwell.layout.adapter.SlidingMenuAdapter;
import br.com.fiap.petwell.layout.fragment.Fragment1;
import br.com.fiap.petwell.layout.fragment.Fragment2;
import br.com.fiap.petwell.layout.fragment.Fragment3;
import br.com.fiap.petwell.layout.model.ItemSlideMenu;
import br.com.fiap.petwell.requesttask.LoginRequestTask;
import br.com.fiap.petwell.requesttask.LogoutRequestTask;
import br.com.fiap.petwell.util.hash.HashUtil;

public class AppNavActivity extends AppCompatActivity {

    private List<ItemSlideMenu> listSliding;
    private SlidingMenuAdapter adp;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    SharedPreferences sharedPreferences;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appnav);

        HashUtil.setHash(this, "9fa7bf2ce2fa9ebec5a3dcaacb38c4dd");

        sharedPreferences = this.getSharedPreferences("Hash", Context.MODE_PRIVATE);
        String hash = sharedPreferences.getString("Hash", "NO_HASH_FOUND");
        if (hash.equals("NO_HASH_FOUND")){
            Intent toLoginAct = new Intent (this, LoginActivity.class);
            startActivity(toLoginAct);
        }

        //Init component
        listView = (ListView) findViewById(R.id.lv_sliding_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listSliding = new ArrayList<>();

        //Add item for sliding list_item_style
        listSliding.add(new ItemSlideMenu(R.drawable.ic_settings, getString(R.string.txtSettings) ));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_login_puppy, "Au Au"));
        adp = new SlidingMenuAdapter(this, listSliding);
        listView.setAdapter(adp);

        //Display icon to open/close sliding list_item_style
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Set title
        setTitle(listSliding.get(0).getTitle());
        //Item selected
        listView.setItemChecked(0, true);
        //Close menu
        drawerLayout.closeDrawer(listView);
        //Display fragment 1 when start
        replaceFragment(0);

        //Handle on item click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title
                setTitle(listSliding.get(position).getTitle());
                //Item selected
                listView.setItemChecked(position, true);
                //Replace Fragment
                replaceFragment(position);
                //Close menu
                drawerLayout.closeDrawer(listView);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawerOpened, R.string.drawerClosed){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        drawerLayout.addDrawerListener(actionBarDrawerToggle);

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
    //Create method replace fragment

    public void replaceFragment(int pos){
        Fragment fragment = null;
        switch (pos){
            case 0 :
                fragment = new Fragment1();
                break;
            case 1 :
                fragment = new Fragment2();
                break;
            case 2 :
                fragment = new Fragment3();
                break;
            default:
                fragment = new Fragment1();
                break;
        }
        if (null!=fragment){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
       }
    }

    public void logout(View v){
        LogoutRequestTask logoutRequestTask = new LogoutRequestTask(this);
        logoutRequestTask.execute();
    }
}
