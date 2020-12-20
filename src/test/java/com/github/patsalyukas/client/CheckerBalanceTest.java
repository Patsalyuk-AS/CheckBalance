package com.github.patsalyukas.client;

import com.github.patsalyukas.device.ATM;
import com.github.patsalyukas.device.ReliabilityOfSelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.outsideclasses.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckerBalanceTest {

    private static Card card;
    private static CardDataBase<Card> dataBase = new CardDataBase<>();
    private static Address address;
    private static Passport passport;
    private static SelfServiceDevice selfServiceDevice;
    private static CheckerBalance client;
    private static Balance balance;

    @BeforeAll
    static void setUp() throws IllegalCardParametersException {
        card = BankCard.getInstance(new BankCardInfo("IVAN", "PETROV", "4256123542131234", "12/21", "652"), "1532", BankCardType.DEBET);
        address = new Address("Moscow area", "Moscow", "Pionerskaya", "100");
        passport = new Passport(7900, 156423, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1980, 2, 15), address);
        selfServiceDevice = new ATM("100000", address, dataBase, new ReliabilityOfSelfServiceDevice(1000));
        client = new CheckerBalance(passport, selfServiceDevice, card);
        balance = new Balance(Currency.RUB, new BigDecimal("15000"));
        DataBaseIninializer.initializeDataBase(dataBase);
    }

    @Test
    void checkBalance() throws BankException, NoSuchProviderException, NoSuchAlgorithmException {
        assertEquals(balance, client.checkBalance());
    }
}