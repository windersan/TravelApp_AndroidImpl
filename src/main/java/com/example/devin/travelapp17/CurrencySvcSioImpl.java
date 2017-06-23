package com.example.devin.travelapp17;

import android.content.Context;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by devin on 6/14/2017.
 */

public class CurrencySvcSioImpl implements ICurrencyService {

    private final String _filename = "Currencies";
    private static List<CurrEntry> _currencies;
    private Context _appContext;

    public CurrencySvcSioImpl(Context context){
        _appContext = context;



        _currencies = new ArrayList<CurrEntry>();

        readFile();
    }


    public CurrEntry create(CurrEntry currEntry) {
        _currencies.add(currEntry);
        writeFile();
        return currEntry;
    }


    public List<CurrEntry> getAllCurrencies(){
        return _currencies;
    }

    public CurrEntry update(CurrEntry currEntry_old, CurrEntry currEntry_new){
        currEntry_old = currEntry_new;
        return currEntry_new;
    }

    public CurrEntry delete(CurrEntry currEntry){
        _currencies.remove(currEntry);
        return currEntry;
    }

    private void readFile(){
        try{
            ObjectInputStream ois = new ObjectInputStream(_appContext.openFileInput(_filename));
            _currencies = (List<CurrEntry>) ois.readObject();
            ois.close();
        }catch(Exception e){
            String TAG = "CurrencySvcSioImpl";
            Log.e(TAG, e.getMessage());
        }
    }

    private void writeFile(){
        try{
            FileOutputStream fos = new FileOutputStream(_filename);
            ObjectOutputStream oos =
                    new ObjectOutputStream(_appContext.openFileOutput(_filename,Context.MODE_APPEND));
            oos.writeObject(_currencies);
            oos.flush();
            oos.close();
        }catch(Exception e){
            String TAG = "CurrencySvcSioImpl";
            Log.e(TAG, e.getMessage());
        }
    }



}