package com.example.graeme.vehiclelog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.graeme.vehiclelog.model.Vehicle;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddVehicleStep6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle_step6);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Vehicle");
        setSupportActionBar(toolbar);

        final Bundle b = getIntent().getExtras().getBundle("addVehicle");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button nextButton = (Button) findViewById(R.id.button6);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddVehicleStep6.this, MainActivity.class);
                addVehicle(b);
                startActivity(intent);

            }
        });
    }

    private void addVehicle(Bundle b)
    {
        String name = b.getString("name");
        String year = b.getString("year");
        String vin = b.getString("vin");
        String date = b.getString("date");
        String engine = b.getString("engine");

        Pattern p = Pattern.compile("(\\d*)-(\\d*)-(\\d)*");
        Matcher m = p.matcher(date);
        m.find();

        Calendar cal = Calendar.getInstance();
        cal.set(Integer.valueOf(m.group(1)), Integer.valueOf(m.group(2)), Integer.valueOf(m.group(3)));

        Date d  = new Date(cal.getTimeInMillis());

        Vehicle newVehicle = new Vehicle(name, Integer.valueOf(year), engine, d, vin);

        DataProvider.getData().add(newVehicle);

        System.out.println(String.format("%s, %s, %s, %s, %s", name, year, vin, date, engine));
    }

}
