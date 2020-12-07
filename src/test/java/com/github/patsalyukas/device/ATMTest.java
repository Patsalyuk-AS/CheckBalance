package com.github.patsalyukas.device;

import com.github.patsalyukas.outsideclasses.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ATMTest {

    DataBase<Card> dataBase = new DataBase<>(new BankCardFactory());
    Card card = new BankCard("4256123542131234", "12/21", "IVAN", "PETROV", 1532, 652, BankCardType.DEBET);
    Balance balance = new Balance(Currency.RUB, new BigDecimal("15000"));
    Address address = new Address("Moscow area", "Moscow", "Pionerskaya", "100");
    SelfServiceDevice selfServiceDevice = new ATM(100000, address, dataBase, new ReliabilityOfSelfServiceDevice(1000));

    @Test
    void returnBalance() throws BankException {
        assertEquals(balance, selfServiceDevice.returnBalance(card));
    }

    @Test
    void giveBackCard() throws SelfServiceDeviceBrokenException {
        assertEquals(Result.SUCCESS, selfServiceDevice.giveBackCard(card));
    }
}