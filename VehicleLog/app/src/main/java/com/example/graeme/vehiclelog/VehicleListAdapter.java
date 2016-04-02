package com.example.graeme.vehiclelog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class VehicleListAdapter extends ArrayAdapter<Vehicle>{

    private List<Vehicle> vehicles;

    public VehicleListAdapter(Context context, int resource, int textViewResourceId, List<Vehicle> objects) {
        super(context, resource, textViewResourceId, objects);
        this.vehicles = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // If list item is not allocated
        if(convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }

        TextView nameText = (TextView) convertView.findViewById(R.id.nameText);
        TextView yearText = (TextView) convertView.findViewById(R.id.yearText);
        TextView engineText = (TextView) convertView.findViewById(R.id.engineText);

        return super.getView(position, convertView, parent);
    }
}