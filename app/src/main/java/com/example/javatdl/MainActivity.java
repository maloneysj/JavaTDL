package com.example.javatdl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  MainActivity extends AppCompatActivity {

    private static final String TAG = "TDLs App: Main ";
    Button btn_addTDL;

    MyApplication myApplication= (MyApplication) this.getApplication();
    List<TDLs> TDLsList;

    DataBaseHelper dataBaseHelper;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TDLsList=myApplication.getTDLsList();
        myApplication.setMainActivityOn(1);

        dataBaseHelper=new DataBaseHelper(MainActivity.this);


        dataBaseHelper.getReadableDatabase();
        List<TDLs> everything = dataBaseHelper.getEverything();

/*
        int z;

        for (z = 1; z < everything.size(); z++) {

            dataBaseHelper.deleteOne(everything.get(z));

        }

 */


        if (everything.size()==0) {

            int i;

            for (i = 0; i < TDLsList.size(); i++) {

                boolean success = dataBaseHelper.addOne(TDLsList.get(i));
                Log.d(TAG, "success= " + success);

            }

        }

        else {

        }



        String everythingString=everything.toString();

        int everythingSize=everything.size();

        int TDLListSize=TDLsList.size();

        Log.d(TAG,"everything string= " + everythingString + "everything size= " + everythingSize +"TDL List Size: " + TDLListSize);



        btn_addTDL=findViewById(R.id.btn_addTDL);

        btn_addTDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, AddEditOne.class);
                startActivity(intent);

            }
        });

        recyclerView=findViewById(R.id.lv_templates);

        //use this setting to improve performance if you know that changes
        //in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        //use a linear layout manager
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //specify an adapter
        //mAdapter=new RecycleViewAdapter(TDLsList, this);
        mAdapter=new RecycleViewAdapter(everything, this);
        recyclerView.setAdapter(mAdapter);

    }

}