package com.example.graeme.vehiclelog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.graeme.vehiclelog.model.VehicleItem;

import static android.R.attr.name;

public class AddItem extends AppCompatActivity {
    private int selectedVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        selectedVehicle = getIntent().getExtras().getInt("selectedVehicle");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(AddItem.this, VehicleDetails.class);
                intent.putExtra("selectedVehicle", selectedVehicle);
                startActivityForResult(intent, 0);
                finish();
                break;
        }
        return true;
    }

    public void addItem(View view) {
        String name = ((EditText) findViewById(R.id.txtAddItemName)).getText().toString();
        String desc1 = ((EditText) findViewById(R.id.txtAddItemDescription1)).getText().toString();
        String desc2 = ((EditText) findViewById(R.id.txtAddItemDescription2)).getText().toString();

        DataProvider.getData().get(selectedVehicle).getItems().add(new VehicleItem(name, desc1, desc2));

        Intent intent = new Intent(AddItem.this, VehicleDetails.class);
        intent.putExtra("selectedVehicle", selectedVehicle);
        startActivityForResult(intent, 0);
        finish();
    }
}
