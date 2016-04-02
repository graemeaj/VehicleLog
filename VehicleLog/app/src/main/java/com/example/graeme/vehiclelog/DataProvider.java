package com.example.graeme.vehiclelog;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataProvider {

    private static List <Vehicle> data = new ArrayList<>();
    private static Date expieryDate = new Date(Calendar.getInstance().getTimeInMillis());

    static {
        //String name, int year, String engineSize, Date expiration, String vin
        data.add(new Vehicle("Honda Civic", 1997, "1.7L", new Date(2016,11,30),"NS7SH773983H7H976"));
        data.add(new Vehicle("Yamaha sport boat", 2005, "75cc", new Date(2017,8,14),"823489729849"));
        data.add(new Vehicle("Ford F-150", 2012, "3.8L", new Date(2019,2,15),"NS7SH773983H7H976"));
        data.add(new Vehicle("ATV", 2010, "125cc", new Date(2012,5,17),"34234262626"));
        data.add(new Vehicle("Honda Civic", 1997, "1.7L", new Date(2016,11,30),"NS7SH773983H7H976"));
        data.add(new Vehicle("Yamaha sport boat", 2005, "75cc", new Date(2017,8,14),"823489729849"));
        data.add(new Vehicle("Ford F-150", 2012, "3.8L", new Date(2019,2,15),"NS7SH773983H7H976"));
        data.add(new Vehicle("ATV", 2010, "125cc", new Date(2012,5,17),"34234262626"));


    }

    public static List<Vehicle> getData(){
        return data;
    }

    public static Date getDate(){
        return expieryDate;
    }

    public static void setDate(Date date){
        expieryDate = date;
    }


}
