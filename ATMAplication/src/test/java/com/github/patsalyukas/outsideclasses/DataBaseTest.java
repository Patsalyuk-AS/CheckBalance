package com.github.patsalyukas.outsideclasses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {

    CardDataBase<Card> dataBase = new CardDataBase<>();

    Card card1 = BankCard.getInstance(new BankCardInfo("IVAN", "PETROV", "4256123542131234", "12/21", "652"), "1532", BankCardType.DEBET);
    Card card2 = BankCard.getInstance(new BankCardInfo("IVAN", "PETROV", "4256123542134526", "12/21", "652"), "1532", BankCardType.DEBET);
    Balance balance = new Balance(Currency.RUB, new BigDecimal("15000"));

    DataBaseTest() throws IllegalCardParametersException {
    }

    @BeforeEach
    void setUp() throws IllegalCardParametersException {
        DataBaseIninializer.initializeDataBase(dataBase);
    }

    @Test
    void validateCard() {
        assertTrue(dataBase.validateCard(card1));
        assertFalse(dataBase.validateCard(card2));
    }

    @Test
    void getBalance() throws BankException {
        assertEquals(balance, dataBase.getBalance(card1));
    }

}