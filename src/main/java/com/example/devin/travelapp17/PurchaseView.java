package com.example.devin.travelapp17;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class PurchaseView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {








               // CurrencySvcSioImpl svc = new CurrencySvcSioImpl(PurchaseView.this.getApplicationContext());

                CurrencySvcSQLiteImpl svc = new CurrencySvcSQLiteImpl(PurchaseView.this.getApplicationContext());

                EditText e1 = (EditText)findViewById(R.id.AmountText);
                String amount_str = e1.getText().toString();
               // double amount = Double.parseDouble(amount_str);

                EditText e2 = (EditText)findViewById(R.id.CurrencyText);
                String currency = e2.getText().toString();

                List<CurrEntry> s = svc.getAllCurrencies();

                boolean j = false;

                for(int i = 0; i < s.size();i++){


                    if(s.get(i).get_currency() == currency){
                        double amount1 = Double.parseDouble(amount_str);
                        double amount2 = Double.parseDouble(s.get(i).get_amount());
                        double amount = amount1 + amount2;
                        String amount_s = Double.toString(amount);
                        CurrEntry u = new CurrEntry(amount_s,currency);
                        CurrEntry u1 = svc.update(u);
                        j=true;
                    }


                }

                if(j==false){
                    CurrEntry c1 = new CurrEntry(amount_str,currency);
                    CurrEntry c = svc.create(c1);
                }


                CurrEntry u = new CurrEntry(amount_str,currency);
                CurrEntry u1 = svc.update(u);


              //  CurrEntry u = new CurrEntry("100","Dollars");

                List<CurrEntry> ss = svc.getAllCurrencies();

                //svc.delete("Currency");


              //  svc.update(u);

                ArrayAdapter<CurrEntry> adapter = new ArrayAdapter<CurrEntry>(PurchaseView.this,
                        android.R.layout.simple_list_item_1, ss);


                ListView listView = (ListView) findViewById(R.id.depositlist);
                listView.setAdapter(adapter);

                //Intent intent1 = new Intent(PurchaseView.this, MainActivity.class);
                //startActivity(intent1);


            }
        });
    }



}
