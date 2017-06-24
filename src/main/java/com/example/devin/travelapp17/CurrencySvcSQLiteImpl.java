package com.example.devin.travelapp17;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CurrencySvcSQLiteImpl extends SQLiteOpenHelper implements ICurrencyService {

    private static final String DBNAME = "currencies.db";
    private static final int DBVERSION = 1;


    public CurrencySvcSQLiteImpl (Context context){

        super ( context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("create table currency (id integer primary key" +
                " autoincrement, amount REAL, currency TEXT )");
    }

    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int i, int i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS currency");
        onCreate(sqLiteDatabase);

    }


    @Override
    public CurrEntry create(CurrEntry currEntry){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("amount", currEntry.get_amount());
        values.put("currency", currEntry.get_currency());



        long rowIdOfInsertedRecord = sqLiteDatabase.insert("currency", null, values);

        sqLiteDatabase.close();
        return currEntry;


    }




    @Override
    public List<CurrEntry> getAllCurrencies(){
        List<CurrEntry> currencies = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("currency", new String[] {"id", "amount", "currency"},
                null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            CurrEntry currEntry = getCurrEntry(cursor);
            currencies.add(currEntry);
            cursor.moveToNext();
        }
        cursor.close();
        return currencies;

    }

    public CurrEntry update(CurrEntry c){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("amount", c.get_amount());
        values.put("currency", c.get_currency());

        int numberOfRowsUpdated = sqLiteDatabase.update("currency", values, "currency = ?",
                new String[] {String.valueOf(c.get_currency())});
        sqLiteDatabase.close();
        return c;

    }



    public void delete(String currency){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        int rowDeleted = sqLiteDatabase.delete("currency", "currency = ?" , new String[]{
                String.valueOf(currency)});
        sqLiteDatabase.close();


    }

    private CurrEntry getCurrEntry(Cursor cursor){

        CurrEntry c = new CurrEntry();
        c.set_amount(cursor.getString(1));
        c.set_currency(cursor.getString(2));
        return c;
    }


}
