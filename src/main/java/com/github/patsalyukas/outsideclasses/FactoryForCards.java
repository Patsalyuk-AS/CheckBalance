package com.github.patsalyukas.outsideclasses;

import java.math.BigInteger;

public interface FactoryForCards {
    Card createCard(String cardNumber, String expDate, String firstName, String lastName, int PIN, int CVI, String type);

    Balance createBalance(Currency currency, BigInteger sum);
}
