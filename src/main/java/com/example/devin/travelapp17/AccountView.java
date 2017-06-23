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
import android.widget.Toast;

import java.util.List;

public class AccountView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //  TextView message = (TextView) findViewById(R.id.message);


        CurrencySvcSioImpl svc = new CurrencySvcSioImpl(this.getApplicationContext());

        CurrEntry c = new CurrEntry(5, "dollars");

        c = svc.create(c);
        c = svc.create(c);
        c = svc.create(c);

        CurrEntry c2 = svc.getAllCurrencies().get(0);

        // message.setText((new Double(c2.get_amount())).toString() + " " + c2.get_currency());

        // FileOutputStream fos = new FileOutputStream("filename");
        // ObjectOutputStream oos =
        //        new ObjectOutputStream(fos);
        // oos.writeObject(_currencies);
        //  oos.flush();
        // oos.close();

        // ArrayList ss = new ArrayList<String>();
        // ss.add("message");
        // ss.add("message");
        //  ss.add("message");
        //  ss.add("message");

        List<CurrEntry> ss = svc.getAllCurrencies();

        ArrayAdapter<CurrEntry> adapter = new ArrayAdapter<CurrEntry>(this,
                android.R.layout.simple_list_item_1, ss);

        //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //  android.R.layout.simple_list_item_1, ss);

        ListView listView = (ListView) findViewById(R.id.depositlist);
        listView.setAdapter(adapter);



        ////  FileOutputStream fos = new FileOutputStream(filename);
        //// ObjectOutputStream oos = new ObjectOutputStream(fos);

        //  // oos.writeInt(12345);
        //  //oos.writeObject("Today");
        // // oos.writeObject(new Date());

        ////   oos.close();



/*
        CurrencySvcSioImpl svc1 = new CurrencySvcSioImpl(this.getApplicationContext());
        List<CurrEntry> list = svc.getAllCurrencies();


        Context context = getApplicationContext();

        CurrEntry c1 = list.get(0);

        CharSequence text = c.get_currency();

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        CurrencySvcSioImpl svc2 = new CurrencySvcSioImpl(this.getApplicationContext());
        CurrEntry c2 = new CurrEntry(5, "dollars");
        svc.create(c);

        TextView message = (TextView) findViewById(R.id.message);
        message.setText(c.get_currency());
*/


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



            }
        });
    }

}


