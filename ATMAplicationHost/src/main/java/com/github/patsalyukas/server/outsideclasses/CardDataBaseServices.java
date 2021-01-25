package com.github.patsalyukas.server.outsideclasses;

public interface CardDataBaseServices<E extends Card> {

    boolean validateCard(E e);

    Balance getBalance(E e) throws BankException;

    void getHistoryOfRequestsOfBalances();

    void addCardToDataBase(E e, Balance balance) throws IllegalCardParametersException;

    void handleBankException(BankException exception);

}
