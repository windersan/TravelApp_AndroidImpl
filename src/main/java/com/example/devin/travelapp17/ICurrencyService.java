package com.example.devin.travelapp17;

import java.util.List;

/**
 * Created by devin on 6/14/2017.
 */

public interface ICurrencyService {
    public CurrEntry create(CurrEntry currEntry);
    public List<CurrEntry> getAllCurrencies();
    public CurrEntry update(CurrEntry currEntry_old, CurrEntry urrEntry_new);
    public CurrEntry delete(CurrEntry currEntry);

}
