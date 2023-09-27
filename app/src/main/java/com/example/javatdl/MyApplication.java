

package com.example.javatdl;

import android.app.Application;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<TDLs> TDLsList=new ArrayList<TDLs>();
    private static int nextId=60;


    public static String getNewItem() {
        return newItem;
    }

    public static void setNewItem(String newItem) {
        MyApplication.newItem = newItem;
    }

    private static String newItem;

    public static int getMainActivityOn() {
        return mainActivityOn;
    }

    public static void setMainActivityOn(int mainActivityOn) {
        MyApplication.mainActivityOn = mainActivityOn;
    }

    private static int mainActivityOn;



    public MyApplication() {
        fillTDLsList();
    }


    private void fillTDLsList() {

        TDLs t0=new TDLs(55, "Today", "test Today");
        TDLs t1=new TDLs(56, "Daily", "test Daily");
        TDLs t2=new TDLs(57, "Weekly", "test Weekly");
        TDLs t3=new TDLs(58, "Monthly", "test Monthly");
        TDLs t4=new TDLs(59, "Yearly", "test Yearly");


        TDLsList.addAll(Arrays.asList(new TDLs[] {t0, t1, t2, t3, t4}));
    }

    public static List<TDLs> getTDLsList() {
        return TDLsList;
    }

    public static void setTDLsList(List<TDLs> TDLsList) {
        MyApplication.TDLsList = TDLsList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}




