package com.github.patsalyukas.outsideclasses;

import java.math.BigInteger;

public class BankCardFactory implements FactoryForCards {


    @Override
    public Card createCard(String cardNumber, String expDate, String firstName, String lastName, int PIN, int CVI, String type) {
        return new BankCard(cardNumber, expDate, firstName, lastName, PIN, CVI, type);
    }

    @Override
    public Balance createBalance(Currency currency, BigInteger sum) {
        return new Balance(currency, sum);
    }

}
