package com.github.patsalyukas;

import com.github.patsalyukas.client.CheckerBalanceOnSelfServiceDevice;
import com.github.patsalyukas.client.Passport;
import com.github.patsalyukas.device.ATM;
import com.github.patsalyukas.device.ReliabilityOfSelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDeviceBrokenException;
import com.github.patsalyukas.outsideclasses.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SelfServiceDeviceBrokenException, NotValidCardException {
        DataBase dataBase = new DataBase(new BankCardFactory());
        Address clientAddress = new Address("Moscow area", "Moscow", "Pionerskaya", "124a", "54");
        Address atmAddress = new Address("Moscow area", "Moscow", "Pionerskaya", "100");
        Passport clientPassport = new Passport(7900, 156423, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1980, 2, 15), clientAddress);
        Card card = new BankCard("4256123542134526", "30/22", "PETR", "IVANOV", 1020, 152, "DEBET");
        SelfServiceDevice atm = new ATM(100000, atmAddress, dataBase, new ReliabilityOfSelfServiceDevice(1000));
        CheckerBalanceOnSelfServiceDevice client = new CheckerBalanceOnSelfServiceDevice(clientPassport, atm, card);
        client.goToSelfServiceDevice();
        client.insertCard();
        System.out.println(client.checkBalance());
        client.getBackCard();
    }

}
