package com.github.patsalyukas.server.device;

import com.github.patsalyukas.server.outsideclasses.Balance;
import com.github.patsalyukas.server.outsideclasses.BankException;
import com.github.patsalyukas.server.outsideclasses.Card;
import com.github.patsalyukas.server.outsideclasses.Result;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface SelfServiceDevice {

    Result takeCard(Card card) throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException;

    Balance returnBalance(Card card) throws BankException, NoSuchProviderException, NoSuchAlgorithmException;

    Result giveBackCard(Card card) throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException;

    void handleError(BankException exception);

}
