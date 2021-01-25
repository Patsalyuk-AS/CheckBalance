package com.github.patsalyukas.server.client;

import com.github.patsalyukas.server.device.SelfServiceDevice;
import com.github.patsalyukas.server.device.SelfServiceDeviceBrokenException;
import com.github.patsalyukas.server.outsideclasses.Card;
import com.github.patsalyukas.server.outsideclasses.Result;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface ATMClientService {

    Result goToSelfServiceDevice();

    Result insertCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException;

    Result getBackCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException;

    SelfServiceDevice getSelfServiceDevice();

    Card getCard();

}
