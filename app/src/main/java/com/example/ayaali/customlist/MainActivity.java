package com.example.ayaali.customlist;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,NavigationView.OnNavigationItemSelectedListener{

    private final String[] listOfText={"facebook","twitter","googleplus","linkedin","wordpress","youtube"};
    private final int[] imagesIds={R.mipmap.facebook,R.mipmap.twitter,R.mipmap.googleplus,R.mipmap.linkedin,R.mipmap.wordpress,R.mipmap.youtube};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdapterList adapterList=new AdapterList(listOfText,imagesIds,this);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapterList);
        listView.setOnItemClickListener(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this,"clivked on"+listOfText[position],Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.aboutUs) {
            Intent main=new Intent("AboutUs");
            startActivity(main);

        } else if (id == R.id.contactUs) {

            Intent main=new Intent("MainActivity");
            startActivity(main);

        } else if (id == R.id.webPage) {

            Uri uriUrl = Uri.parse("http://hadeya.net/");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(launchBrowser);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
