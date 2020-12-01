package com.github.patsalyukas.client;

import com.github.patsalyukas.device.ATM;
import com.github.patsalyukas.device.ReliabilityOfSelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDeviceBrokenException;
import com.github.patsalyukas.outsideclasses.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientOfSelfServiceDeviceTest {

    Card card = new BankCard("4256123542131234", "12/21", "IVAN", "PETROV", 1532, 652, "DEBET");
    DataBase dataBase = new DataBase(new BankCardFactory());
    Address atmAddress = new Address("Moscow area", "Moscow", "Pionerskaya", "100");
    Address clientAddress = new Address("Moscow area", "Moscow", "Pionerskaya", "124a", "54");
    Passport clientPassport = new Passport(7900, 156423, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1980, 2, 15), clientAddress);
    SelfServiceDevice atm = new ATM(100000, atmAddress, dataBase, new ReliabilityOfSelfServiceDevice(1000));
    ClientOfSelfServiceDevice client = new ClientOfSelfServiceDevice(clientPassport, atm, card);

    @Test
    void goToSelfServiceDevice() {
        assertEquals(Result.SUCCESS, client.goToSelfServiceDevice());
    }

    @Test
    void insertCard() throws SelfServiceDeviceBrokenException {
        assertEquals(Result.SUCCESS, client.insertCard());
    }

    @Test
    void getBackCard() throws SelfServiceDeviceBrokenException {
        assertEquals(Result.SUCCESS, client.getBackCard());
    }
}