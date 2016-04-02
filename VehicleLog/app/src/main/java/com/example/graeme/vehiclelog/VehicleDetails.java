package com.example.graeme.vehiclelog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.example.graeme.vehiclelog.model.Vehicle;

import java.util.Calendar;

public class VehicleDetails extends AppCompatActivity {
    private int selectedVehicle;
    private ListView itemListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        itemListView = (ListView) findViewById(R.id.itemListView);

        ////////////////////////////////////////
        // Set info from selection
        if(getIntent().getExtras() != null) {
            selectedVehicle = getIntent().getExtras().getInt("selectedVehicle");
            setVehicle(DataProvider.getData().get(selectedVehicle), itemListView);
        }

        ////////////////////////////////////////
        // Go to Add Item Screen
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VehicleDetails.this, AddItem.class);

                intent.putExtra("selectedVehicle", selectedVehicle);

                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        setVehicle(DataProvider.getData().get(selectedVehicle), itemListView);
    }

    private void setVehicle(Vehicle vehicle, ListView itemListView){
        Calendar cal = Calendar.getInstance();
        cal.setTime(vehicle.getExpiration());

        String expieryDate = String.format("%d-%d-%d",
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));

        ((TextView) findViewById(R.id.yearValue)).setText(String.valueOf(vehicle.getYear()));
        ((TextView) findViewById(R.id.engineValue)).setText(vehicle.getEngineSize());
        ((TextView) findViewById(R.id.expiresValue)).setText(expieryDate);
        ((TextView) findViewById(R.id.vinValue)).setText(vehicle.getVin());

        VehicleItemListAdapter adapter = new VehicleItemListAdapter(
                this, android.R.layout.simple_list_item_1, android.R.id.text1, vehicle.getItems());
        itemListView.setAdapter(adapter);
    }
}
