package com.example.graeme.vehiclelog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import com.example.graeme.vehiclelog.model.DatePickerFragment;

import java.util.Calendar;
import java.util.Date;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Options");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        updateLicenseText();
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

        TextView dateText = (TextView) findViewById(R.id.licenseDate);
        dateText.setText(String.format("%d-%d-%d", year, month, day));
    }
}
