package com.github.patsalyukas.server.client;

import com.github.patsalyukas.common.utils.Currency;
import com.github.patsalyukas.server.device.SelfServiceDevice;
import com.github.patsalyukas.server.outsideclasses.Balance;
import com.github.patsalyukas.server.outsideclasses.BankException;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

//@Service
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
