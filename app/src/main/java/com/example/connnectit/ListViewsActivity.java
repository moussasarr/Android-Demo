package com.example.connnectit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewsActivity extends AppCompatActivity {

    ArrayAdapter<String>  myStringAdapter;
    Adapter myPlacesAdapter;
    ListView listView;

    Place[] myPlacesArray = new Place[]{
            new Place("Art House", 78701 , "art" ,"This place is tasteful"),
            new Place("Bike Shop", 78702, "bike","Cool bikes"),
            new Place("Camera Fix", 78702, "polaroids","These guys always rip me off"),
            new Place("YETspace", 78702, "radio", "I LOVE this place"),
            new Place("Secret Space Pad", 94103, "rocket","Not very secret, are they?"),
            new Place("Taylor's Tailor", 60610, "scissors" , "Looking good.."),
            new Place("Boathouse", 78701, "shipwheel" ,"That place is full of pirates!"),
            new Place("Not Apple Store", 78702, "tablet", "Android rules!"),
            new Place("Tool Battleground", 78702, "tools", "That place is dangerous"),
            new Place("Travelpediocity", 78702, "travelerbag" ,"This is where i booked my summer trip"),
            new Place("UFO Pick-a-part", 90210, "ufo","Out of this world stuff here."),
            new Place("Spawrk's House", 99999, "volume", "The music is always so good"),
    };

    String[] myStringArray = new String[]{
            "Art House",
            "Bike Shop",
            "Camera Fix",
            "YETspace",
            "Secret Space Pad",
            "Taylor's Tailor",
            "Boathouse",
            "Not Apple Store",
            "Tool Battleground",
            "Travelpediocity",
            "UFO Pick-a-part",
            "Spawrk's House",
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_views);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        myStringAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myStringArray);
        listView = findViewById(R.id.listV);

        listView.setAdapter(myStringAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), myStringArray[position], Toast.LENGTH_SHORT).show();
            }
        });


    }

}
