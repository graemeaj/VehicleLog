package com.example.graeme.vehiclelog;

import com.example.graeme.vehiclelog.model.Vehicle;
import com.example.graeme.vehiclelog.model.VehicleItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataProvider {

    private static List <Vehicle> data = new ArrayList<>();
    private static Date expiryDate = new Date(Calendar.getInstance().getTimeInMillis());

    static {
        //String name, int year, String engineSize, Date expiration, String vin
        data.add(new Vehicle("Honda Civic", 1997, "1.7L", getRandomDate(),"NS7SH773983H7H976"));
        data.add(new Vehicle("Yamaha sport boat", 2005, "75cc", getRandomDate(),"823489729849"));
        data.add(new Vehicle("Ford F-150", 2012, "3.8L", getRandomDate(),"NS7SH773983H7H976"));
        data.add(new Vehicle("ATV", 2010, "125cc", getRandomDate(),"34234262626"));
        data.add(new Vehicle("Honda Civic", 1997, "1.7L", getRandomDate(),"NS7SH773983H7H976"));
        data.add(new Vehicle("Yamaha sport boat", 2005, "75cc", getRandomDate(),"823489729849"));
        data.add(new Vehicle("Ford F-150", 2012, "3.8L", getRandomDate(),"NS7SH773983H7H976"));
        data.add(new Vehicle("ATV", 2010, "125cc", getRandomDate(),"34234262626"));

        data.get(0).getItems().add(new VehicleItem("Engine Oil", "10-W30", "Synthetic Only"));
    }

    public static List<Vehicle> getData(){
        return data;
    }

    public static Date getDate(){
        return expiryDate;
    }

    public static void setDate(Date date){
        expiryDate = date;
    }

    private static Date getRandomDate(){
        Calendar cal = Calendar.getInstance();

        cal.set((int)(Math.random()*50) + 1966, (int)(Math.random()*12), (int)(Math.random()*28));

        return new Date(cal.getTimeInMillis());
    }


}
