package com.example.graeme.vehiclelog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddVehicleStep5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle_step5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Vehicle");
        setSupportActionBar(toolbar);

        final Bundle b = new Bundle();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button nextButton = (Button) findViewById(R.id.button5);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddVehicleStep5.this, AddVehicleStep6.class);
                b.putString("engine", ((TextView) findViewById(R.id.editText6)).getText().toString());
                intent.putExtra("addVehicle", b);
                startActivity(intent);
            }
        });
    }

}
