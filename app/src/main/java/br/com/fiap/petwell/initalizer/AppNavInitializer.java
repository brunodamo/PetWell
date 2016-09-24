package br.com.fiap.petwell.initalizer;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.petwell.activity.R;
import br.com.fiap.petwell.layout.adapter.SlidingMenuAdapter;
import br.com.fiap.petwell.layout.fragment.Fragment1;
import br.com.fiap.petwell.layout.fragment.Fragment2;
import br.com.fiap.petwell.layout.fragment.Fragment3;
import br.com.fiap.petwell.layout.model.ItemSlideMenu;



public class AppNavInitializer {

    private Activity activity;


    public AppNavInitializer(Activity activity){
        this.activity = activity;
    }

    private List<ItemSlideMenu> listSliding;
    private SlidingMenuAdapter adp;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    public void componentInitializer(){
        listView = (ListView) activity.findViewById(R.id.lv_sliding_menu);
        drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        listSliding = new ArrayList<>();
    }

    public void addItemToSliding(){
        listSliding.add(new ItemSlideMenu(0, activity.getString(R.string.fragmentRegisterAlimentador)));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_settings, activity.getString(R.string.txtSettings) ));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_login_puppy, "Au Au"));
        adp = new SlidingMenuAdapter(activity, listSliding);
        listView.setAdapter(adp);
    }

    public void setTitle(){
        activity.setTitle(listSliding.get(0).getTitle());
    }

    public void itemSelected(){
        listView.setItemChecked(0, true);
    }

    public void closeMenu(){
        drawerLayout.closeDrawer(listView);
    }

    public void handleOnItemClick(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title
                activity.setTitle(listSliding.get(position).getTitle());
                //Item selected
                listView.setItemChecked(position, true);
                //Replace Fragment
                replaceFragment(position);
                //Close menu
                drawerLayout.closeDrawer(listView);
            }
        });
    }

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

        FragmentManager fragmentManager = activity.getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void actionBarToggle(){

        actionBarDrawerToggle = new ActionBarDrawerToggle(activity, drawerLayout, R.string.drawerOpened, R.string.drawerClosed){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                activity.invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                activity.invalidateOptionsMenu();
            }
        };
    }
    public void addDrawerListener(){
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

}
