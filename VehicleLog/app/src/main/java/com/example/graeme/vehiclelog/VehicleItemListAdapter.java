package com.example.graeme.vehiclelog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.graeme.vehiclelog.model.Vehicle;
import com.example.graeme.vehiclelog.model.VehicleItem;

import java.util.List;

public class VehicleItemListAdapter extends ArrayAdapter<VehicleItem>{

    private List<VehicleItem> items;

    public VehicleItemListAdapter(Context context, int resource, int textViewResourceId, List<VehicleItem> objects) {
        super(context, resource, textViewResourceId, objects);
        this.items = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_vehicle_item, parent, false);
        }

        VehicleItem curItem = items.get(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.itemNameText);
        TextView description1 = (TextView) convertView.findViewById(R.id.description1);
        TextView description2 = (TextView) convertView.findViewById(R.id.description2);

        nameText.setText(curItem.getName());
        description1.setText(curItem.getDescription1());
        description2.setText(curItem.getDescription2());

        return convertView;
    }
}
