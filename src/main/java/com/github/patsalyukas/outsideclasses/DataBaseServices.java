package com.github.patsalyukas.outsideclasses;

public interface DataBaseServices {

    boolean validateCard(Card card);

    Balance getBalance(Card card) throws BankException;

    void showHistoryOfRequestsOfBalances();

    void handleBankException(BankException exception);

}
