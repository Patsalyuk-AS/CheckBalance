package com.github.patsalyukas.client;

import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDeviceBrokenException;
import com.github.patsalyukas.outsideclasses.Card;
import com.github.patsalyukas.outsideclasses.Result;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface ATMClientService {

    Result goToSelfServiceDevice();

    Result insertCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException;

    Result getBackCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException;

    SelfServiceDevice getSelfServiceDevice();

    Card getCard();

}
