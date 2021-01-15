package com.github.patsalyukas.client;

import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.outsideclasses.Balance;
import com.github.patsalyukas.outsideclasses.BankException;
import com.github.patsalyukas.outsideclasses.Currency;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class CheckerBalance implements BalanceOperation {

    private Balance balance;
    private ATMClientService atmClientService;

    public CheckerBalance(ATMClientService atmClientService) {
        this.atmClientService = atmClientService;
        balance = new Balance(Currency.RUB, new BigDecimal("0"));
    }

    public Balance checkBalance() throws BankException, NoSuchProviderException, NoSuchAlgorithmException {
        SelfServiceDevice selfServiceDevice = atmClientService.getSelfServiceDevice();
        atmClientService.goToSelfServiceDevice();
        atmClientService.insertCard();
        balance = selfServiceDevice.returnBalance(atmClientService.getCard());
        atmClientService.getBackCard();
        return balance;
    }

}
