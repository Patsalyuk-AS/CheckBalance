package com.github.patsalyukas.client;

import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDeviceBrokenException;
import com.github.patsalyukas.outsideclasses.Card;
import com.github.patsalyukas.outsideclasses.Moving;
import com.github.patsalyukas.outsideclasses.Result;
import lombok.Getter;
import lombok.Setter;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Getter
@Setter
public class ATMClient {

    private Passport passport;
    private SelfServiceDevice selfServiceDevice;
    private Card card;

    public ATMClient(Passport passport, SelfServiceDevice selfServiceDevice, Card card) {
        this.passport = passport;
        this.selfServiceDevice = selfServiceDevice;
        this.card = card;
    }

    Result goToSelfServiceDevice() {
        return Moving.move(Wish.YES);
    }

    Result insertCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException {
        return selfServiceDevice.takeCard(card);
    }

    Result getBackCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException {
        return selfServiceDevice.giveBackCard(card);
    }

}
