package com.example.profilecreator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.println;

public class ProfileGrid extends AppCompatActivity {

    DataBaseHelper helper;

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_grid);
        helper = new DataBaseHelper(ProfileGrid.this);
        List<String> list = helper.readDataFromDB();

        lvItems = (ListView) findViewById(R.id.user_container);
        //creating array of todo items
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        itemsAdapter.add(list.toString());



        onAddItem();

    }

    public void onAddItem() {
        //adding the user todo items to listview

        String name = getIntent().getExtras().getString("Name");
        String email = getIntent().getExtras().getString("Email");
        String user_id = getIntent().getExtras().getString("userId");
        String birthday = getIntent().getExtras().getString("brthday");
        String country = getIntent().getExtras().getString("country");
        String address = getIntent().getExtras().getString("Address");
        String etNewItem = name + " \n" +email +" \n" +user_id+" \n" +birthday+" \n" +address+" \n" +country;

        itemsAdapter.add(etNewItem);

    }


}

