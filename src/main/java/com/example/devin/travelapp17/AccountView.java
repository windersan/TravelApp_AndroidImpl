package com.example.devin.travelapp17;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class AccountView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                CurrencySvcSQLiteImpl svc = new CurrencySvcSQLiteImpl(AccountView.this.getApplicationContext());



                List<CurrEntry> ss = svc.getAllCurrencies();



                ArrayAdapter<CurrEntry> adapter = new ArrayAdapter<CurrEntry>(AccountView.this,
                        android.R.layout.simple_list_item_1, ss);

                ListView listView = (ListView) findViewById(R.id.accountlist);
                listView.setAdapter(adapter);




            }
        });
    }

}


