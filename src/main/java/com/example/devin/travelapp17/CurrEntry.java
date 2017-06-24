package com.example.devin.travelapp17;

import java.io.Serializable;

/**
 * Created by devin on 6/14/2017.
 */

public class CurrEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    private String _amount ;
    private String _currency;

    public CurrEntry(){}
    public CurrEntry(String amount, String currency){
        this._amount = amount;
        this._currency = currency;
    }

    public String get_amount() {return _amount;}
    public String get_currency(){return _currency;}

    public void set_amount(String amount){this._amount = amount;}
    public void set_currency(String currency){this._currency = currency;}

    @Override
    public String toString(){return ((new Double(this.get_amount())).toString() + " " +
            this.get_currency());}
}
