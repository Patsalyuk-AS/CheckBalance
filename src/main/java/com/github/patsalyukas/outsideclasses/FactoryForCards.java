package com.github.patsalyukas.outsideclasses;

import java.math.BigDecimal;

public interface FactoryForCards {
    Card createCard(String cardNumber, String expDate, String firstName, String lastName, int PIN, int CVI, BankCardType type);

    Balance createBalance(Currency currency, BigDecimal sum);
}
