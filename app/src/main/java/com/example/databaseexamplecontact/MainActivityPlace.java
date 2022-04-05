package com.example.databaseexamplecontact;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivityPlace extends AppCompatActivity{
    ListView listPlaceView;
    DatabaseHandlerPlace db;
    List<Place> listPlaces;
    int pos =-1;
    PlaceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_list);
        init();
        listPlaces = db.getAllPlace();
        if(listPlaces.isEmpty()){
            System.exit(0);
        }
        adapter = new PlaceAdapter(this, listPlaces, R.layout.place_items);
        listPlaceView.setAdapter(adapter);

        listPlaceView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pos = i;
         }
        });
    }
    private void init() {
        db = new DatabaseHandlerPlace(this);
        listPlaceView = (ListView) findViewById(R.id.idlvwName);
 }
    void refresh(){
        listPlaces = db.getAllPlace();
        adapter = new PlaceAdapter(this, listPlaces, R.layout.place_items);
        listPlaceView.setAdapter(adapter);
    }
}