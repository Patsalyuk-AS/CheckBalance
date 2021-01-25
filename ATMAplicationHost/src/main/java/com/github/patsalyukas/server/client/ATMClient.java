package com.github.patsalyukas.server.client;

import com.github.patsalyukas.common.utils.Wish;
import com.github.patsalyukas.server.device.SelfServiceDevice;
import com.github.patsalyukas.server.device.SelfServiceDeviceBrokenException;
import com.github.patsalyukas.server.outsideclasses.Card;
import com.github.patsalyukas.server.outsideclasses.ClientMoving;
import com.github.patsalyukas.server.outsideclasses.Result;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Getter
@Setter
public class ATMClient implements ATMClientService {

    @NotNull
    private Passport passport;
    @NotNull
    private SelfServiceDevice selfServiceDevice;
    @NotNull
    private Card card;

    public ATMClient(Passport passport, SelfServiceDevice selfServiceDevice, Card card) {
        this.passport = passport;
        this.selfServiceDevice = selfServiceDevice;
        this.card = card;
    }

    public Result goToSelfServiceDevice() {
        return new ClientMoving().move(Wish.YES);
    }

    public Result insertCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException {
        return selfServiceDevice.takeCard(card);
    }

    public Result getBackCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException {
        return selfServiceDevice.giveBackCard(card);
    }

}
