package com.github.patsalyukas;

import com.github.patsalyukas.client.CheckerBalance;
import com.github.patsalyukas.client.Passport;
import com.github.patsalyukas.device.ATM;
import com.github.patsalyukas.device.ReliabilityOfSelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.outsideclasses.*;
import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDate;

@Slf4j
public class Main {

    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException, IllegalCardParametersException {
        log.info("Starting application.");
        CardDataBase<Card> dataBase = new CardDataBase<>();
        try {
            DataBaseIninializer.initializeDataBase(dataBase);
        } catch (IllegalCardParametersException exception) {
            dataBase.handleBankException(exception);
        }
        Address clientAddress = new Address("Moscow area", "Moscow", "Pionerskaya", "124a", "54");
        Address atmAddress = new Address("Moscow area", "Moscow", "Pionerskaya", "100");
        Passport clientPassport = new Passport(7900, 156423, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1980, 2, 15), clientAddress);
        Card card = BankCard.getInstance(new BankCardInfo("PETR", "IVANOV", "4256123542134526", "30/12", "152"), "1020", BankCardType.DEBET);
        SelfServiceDevice atm = new ATM("100000", atmAddress, dataBase, new ReliabilityOfSelfServiceDevice(1000));
        CheckerBalance checkerBalance = new CheckerBalance(clientPassport, atm, card);
        try {
            log.info(checkerBalance.checkBalance().toString());
            log.info(checkerBalance.checkBalance().toString());
        } catch (BankException exception) {
            atm.handleError(exception);
        }
        dataBase.getHistoryOfRequestsOfBalances();
        log.info("Finishing application.");

    }

}
