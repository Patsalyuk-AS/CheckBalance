package com.github.patsalyukas.outsideclasses;

import java.math.BigDecimal;

public interface FactoryForCards<E extends Card> {
    E createCard(String firstName, String lastName, String cardNumber, String expDate, String pin, String cvi, BankCardType type) throws IllegalCardParametersException;

    E createCard(E e) throws IllegalCardParametersException;

    Balance createBalance(Currency currency, BigDecimal sum);
}
