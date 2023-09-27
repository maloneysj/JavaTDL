

package com.example.javatdl;

import static com.example.javatdl.TDLs.valueOf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String TDLS_TABLE = "TDLs_TABLE";
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String ITEMS = "ITEMS";

    /*
    List<TDLs> TDLsList;
    MyApplication myApplication= (MyApplication) this.getApplication();

     */

    public DataBaseHelper(@Nullable Context context) {
        super(context, "TDL1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String createTableStatement= "CREATE TABLE " + TDLS_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + ITEMS + " TEXT)";
        sqLiteDatabase.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists TDLsTable");

    }

    public boolean addOne(TDLs tdLs) {

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        //cv.put(ID, tdLs.getId());
        cv.put(NAME, tdLs.getName());
        cv.put(ITEMS, tdLs.getItems());

        long insert = sqLiteDatabase.insert(TDLS_TABLE, null, cv);

        if (insert==-1) {
            return false;
        } else {
            return true;
        }

    }

    public void updateItems(TDLs tdLs) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(ITEMS, tdLs.getItems());

        sqLiteDatabase.update(TDLS_TABLE, cv, ID + " = " + tdLs.getId(), null);

    }


    public boolean deleteOne(TDLs tdLs) {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String queryString="DELETE FROM " + TDLS_TABLE + " WHERE " + ID + " = " + tdLs.getId();

        Cursor cursor = sqLiteDatabase.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            return true;
        }
        else {
            return false;
        }
    }




    public List<TDLs> getEverything() {

        List<TDLs> returnList=new ArrayList<>();

        String queryString="SELECT * FROM " + TDLS_TABLE;

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            do {
                int id=cursor.getInt(0);
                String name= cursor.getString(1);
                String item= cursor.getString(2);

                TDLs newTDLs=new TDLs(id,name,item);
                returnList.add(newTDLs);
            } while(cursor.moveToNext());
        }
        else {

        }

        cursor.close();
        sqLiteDatabase.close();
        return returnList;


    }


}


