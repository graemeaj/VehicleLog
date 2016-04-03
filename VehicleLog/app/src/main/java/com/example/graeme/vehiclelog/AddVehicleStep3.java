package com.example.graeme.vehiclelog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddVehicleStep3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle_step3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Vehicle");
        setSupportActionBar(toolbar);

        final Bundle b = getIntent().getExtras().getBundle("addVehicle");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button nextButton = (Button) findViewById(R.id.button3);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddVehicleStep3.this, AddVehicleStep4.class);
                b.putString("vin", ((EditText) findViewById(R.id.editText5)).getText().toString());
                intent.putExtra("addVehicle", b);
                startActivity(intent);
            }
        });
    }

}
