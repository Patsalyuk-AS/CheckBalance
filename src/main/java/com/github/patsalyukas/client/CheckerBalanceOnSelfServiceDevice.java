package com.github.patsalyukas.client;

import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDeviceBrokenException;
import com.github.patsalyukas.outsideclasses.Balance;
import com.github.patsalyukas.outsideclasses.Card;
import com.github.patsalyukas.outsideclasses.Currency;
import com.github.patsalyukas.outsideclasses.NotValidCardException;

import java.math.BigInteger;

public class CheckerBalanceOnSelfServiceDevice extends ClientOfSelfServiceDevice {

    private Balance balance;

    public CheckerBalanceOnSelfServiceDevice(Passport passport, SelfServiceDevice selfServiceDevice, Card card) {
        super(passport, selfServiceDevice, card);
        balance = new Balance(Currency.RUB, new BigInteger("0"));
    }

    public Balance checkBalance() throws SelfServiceDeviceBrokenException, NotValidCardException {
        SelfServiceDevice selfServiceDevice = getSelfServiceDevice();
        balance = selfServiceDevice.returnBalance(getCard());
        return balance;

    }

}
