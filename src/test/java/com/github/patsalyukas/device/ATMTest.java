package com.github.patsalyukas.device;

import com.github.patsalyukas.outsideclasses.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ATMTest {

    Card card = BankCard.getInstance(new BankCardInfo("IVAN", "PETROV", "4256123542131234", "12/21", "652"), "1532", BankCardType.DEBET);
    CardDataBase<Card> dataBase = new CardDataBase<>();
    Balance balance = new Balance(Currency.RUB, new BigDecimal("15000"));
    Address address = new Address("Moscow area", "Moscow", "Pionerskaya", "100");
    SelfServiceDevice selfServiceDevice = new ATM(100000, address, dataBase, new ReliabilityOfSelfServiceDevice(1000));

    ATMTest() throws IllegalCardParametersException {
    }

    @BeforeEach
    void setUp() throws IllegalCardParametersException {
        DataBaseIninializer.initializeDataBase(dataBase);
    }

    @Test
    void returnBalance() throws BankException, NoSuchProviderException, NoSuchAlgorithmException {
        assertEquals(balance, selfServiceDevice.returnBalance(card));
    }

    @Test
    void giveBackCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException {
        assertEquals(Result.SUCCESS, selfServiceDevice.giveBackCard(card));
    }
}