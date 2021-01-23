package com.github.patsalyukas.controllers;

import com.github.patsalyukas.client.ATMClient;
import com.github.patsalyukas.client.ATMClientService;
import com.github.patsalyukas.client.CheckerBalance;
import com.github.patsalyukas.client.Passport;
import com.github.patsalyukas.device.ATM;
import com.github.patsalyukas.device.ReliabilityOfSelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.outsideclasses.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDate;
import java.time.Month;

@Slf4j
@RestController
public class BalanceController {

    @Autowired //без аннотации выкидывает NPE
    private CardDataBaseServices<Card> dataBase;

    @GetMapping("/balance")
    public Balance getBalance() throws NoSuchProviderException, NoSuchAlgorithmException, BankException {
        try {
            DataBaseIninializer.initializeDataBase(dataBase);
        } catch (IllegalCardParametersException exception) {
            dataBase.handleBankException(exception);
        }
        Address clientAddress = new Address("Moscow area", "Moscow", "Pionerskaya", "124a", "54");
        Address atmAddress = new Address("Moscow area", "Moscow", "Pionerskaya", "100");
        Passport clientPassport = new Passport(7900, 156423, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1980, Month.FEBRUARY, 15), clientAddress);
        Card card = BankCard.getInstance(new BankCardInfo("PETR", "IVANOV", "4256123542134526", "30/12", "152"), "1020", BankCardType.DEBET);
        SelfServiceDevice atm = new ATM("100000", atmAddress, dataBase, new ReliabilityOfSelfServiceDevice(1000));
        ATMClientService atmClientService = new ATMClient(clientPassport, atm, card);
        CheckerBalance checkerBalance = new CheckerBalance(atmClientService);
        return checkerBalance.checkBalance();
    }


}
