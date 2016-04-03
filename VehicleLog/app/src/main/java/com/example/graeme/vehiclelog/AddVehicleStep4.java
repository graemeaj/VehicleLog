package com.example.graeme.vehiclelog;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.graeme.vehiclelog.model.DatePickerFragment;

import java.util.Calendar;
import java.util.Date;

public class AddVehicleStep4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle_step4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Vehicle");
        setSupportActionBar(toolbar);

        final Bundle b = getIntent().getExtras().getBundle("addVehicle");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button nextButton = (Button) findViewById(R.id.button4);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddVehicleStep4.this, AddVehicleStep5.class);

                b.putString("date", ((TextView) findViewById(R.id.lblAddItemDescription1)).getText().toString());
                intent.putExtra("addVehicle", b);
                startActivity(intent);
            }
        });
    }


    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar cal = Calendar.getInstance();

                cal.set(year, monthOfYear, dayOfMonth);

                DataProvider.setDate(new Date(cal.getTimeInMillis()));
                updateLicenseText();
            }
        };
        newFragment.show(getFragmentManager(), "datePicker");
    }

    private void updateLicenseText(){

        Calendar cal = Calendar.getInstance();
        cal.setTime(DataProvider.getDate());

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        TextView dateText = (TextView) findViewById(R.id.lblAddItemDescription1);
        dateText.setText(String.format("%d-%d-%d", year, month, day));
    }
}
