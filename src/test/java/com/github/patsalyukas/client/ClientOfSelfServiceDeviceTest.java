package com.github.patsalyukas.client;

import com.github.patsalyukas.device.ATM;
import com.github.patsalyukas.device.ReliabilityOfSelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDeviceBrokenException;
import com.github.patsalyukas.outsideclasses.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientOfSelfServiceDeviceTest {

    Card card = BankCard.getInstance(new BankCardInfo("IVAN", "PETROV", "4256123542131234", "12/21", "652"), "1532", BankCardType.DEBET);
    CardDataBase<Card> dataBase = new CardDataBase<>();
    Address atmAddress = new Address("Moscow area", "Moscow", "Pionerskaya", "100");
    Address clientAddress = new Address("Moscow area", "Moscow", "Pionerskaya", "124a", "54");
    Passport clientPassport = new Passport(7900, 156423, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1980, 2, 15), clientAddress);
    SelfServiceDevice atm = new ATM(100000, atmAddress, dataBase, new ReliabilityOfSelfServiceDevice(1000));
    ClientOfSelfServiceDevice ClientOfSelfServiceDevice = new ClientOfSelfServiceDevice(clientPassport, atm, card);

    ClientOfSelfServiceDeviceTest() throws IllegalCardParametersException {
    }

    @BeforeEach
    void setUp() throws IllegalCardParametersException {
        DataBaseIninializer.initializeDataBase(dataBase);
    }

    @Test
    void goToSelfServiceDevice() {
        assertEquals(Result.SUCCESS, ClientOfSelfServiceDevice.goToSelfServiceDevice());
    }

    @Test
    void insertCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException {
        assertEquals(Result.SUCCESS, ClientOfSelfServiceDevice.insertCard());
    }

    @Test
    void getBackCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException {
        assertEquals(Result.SUCCESS, ClientOfSelfServiceDevice.getBackCard());
    }
}