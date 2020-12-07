package com.github.patsalyukas.outsideclasses;

import java.math.BigDecimal;

public interface DataBaseServices<E extends Card> {

    boolean validateCard(E e);

    Balance getBalance(E e) throws BankException;

    void showHistoryOfRequestsOfBalances();

    void addCardToDataBase(String cardNumber, String expDate, String firstName, String lastName, int PIN, int CVI, BankCardType type, Currency currency, BigDecimal sum);

    void handleBankException(BankException exception);

}
