package com.example.devin.travelapp17;



import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



public class DepositView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);




        CurrencySvcSioImpl svc = new CurrencySvcSioImpl(this.getApplicationContext());

        CurrEntry c = new CurrEntry(5, "dollars");


        c = svc.create(c); //first one is blocked by our view
        c = svc.create(c);
        c = svc.create(c);

        CurrEntry c2 = svc.getAllCurrencies().get(0);



        List<CurrEntry> ss = svc.getAllCurrencies();

        ArrayAdapter<CurrEntry> adapter = new ArrayAdapter<CurrEntry>(this,
                android.R.layout.simple_list_item_1, ss);



        ListView listView = (ListView) findViewById(R.id.depositlist);
        listView.setAdapter(adapter);





        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



            }
        });
    }

}
