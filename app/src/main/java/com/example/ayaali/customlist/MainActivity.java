package com.example.ayaali.customlist;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

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
}
