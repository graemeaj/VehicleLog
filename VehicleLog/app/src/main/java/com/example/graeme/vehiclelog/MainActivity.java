package com.example.graeme.vehiclelog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.graeme.vehiclelog.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Vehicles");
        setSupportActionBar(toolbar);
        final List<Vehicle> allVehicles = DataProvider.getData();


        ////////////////////////////////////////
        // Populate list view
        ListView listView = (ListView) findViewById(R.id.listView);
        VehicleListAdapter adapter = new VehicleListAdapter(
                this, android.R.layout.simple_list_item_1, android.R.id.text1, allVehicles);
        listView.setAdapter(adapter);

        ////////////////////////////////////////
        // On Item Click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, VehicleDetails.class);

                intent.putExtra("selectedVehicle", position);

                startActivity(intent);
            }
        });

        ////////////////////////////////////////
        // Floating Add Vehicle Button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addVehicle);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddVehicleStep1.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
