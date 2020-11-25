package com.github.patsalyukas.outsideclasses;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {

    DataBase dataBase = new DataBase(new BankCardFactory());
    Card card1 = new BankCard("4256123542131234", "12/21", "IVAN", "PETROV", 1532, 652, "DEBET");
    Card card2 = new BankCard("4256123542134526", "12/21", "IVAN", "PETROV", 1532, 652, "DEBET");
    Balance balance = new Balance(Currency.RUB, new BigDecimal("15000"));

    @Test
    void validateCard() {
        assertTrue(dataBase.validateCard(card1));
        assertFalse(dataBase.validateCard(card2));
    }

    @Test
    void getBalance() throws NotValidCardException {
        assertEquals(balance, dataBase.getBalance(card1));

    }
}