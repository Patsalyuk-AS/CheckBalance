package com.github.patsalyukas.client;

import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.outsideclasses.Balance;
import com.github.patsalyukas.outsideclasses.BankException;
import com.github.patsalyukas.outsideclasses.Card;
import com.github.patsalyukas.outsideclasses.Currency;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class CheckerBalance extends ATMClient {

    private Balance balance;

    public CheckerBalance(Passport passport, SelfServiceDevice selfServiceDevice, Card card) {
        super(passport, selfServiceDevice, card);
        balance = new Balance(Currency.RUB, new BigDecimal("0"));
    }

    public Balance checkBalance() throws BankException, NoSuchProviderException, NoSuchAlgorithmException {
        SelfServiceDevice selfServiceDevice = getSelfServiceDevice();
        goToSelfServiceDevice();
        insertCard();
        balance = selfServiceDevice.returnBalance(getCard());
        getBackCard();
        return balance;
    }

}
