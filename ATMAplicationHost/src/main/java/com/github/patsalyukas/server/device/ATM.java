package com.github.patsalyukas.server.device;

import com.github.patsalyukas.server.outsideclasses.*;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Value
public class ATM implements SelfServiceDevice {

    @NotNull
    private final String numberATM;
    @NotNull
    private final Address addressATM;
    @NotNull
    private final CardDataBaseServices<Card> cardDataBase;
    @NotNull
    private final Reliability reliability;

    @Override
    public Result takeCard(Card card) throws NoSuchProviderException, NoSuchAlgorithmException {
        try {
            checkForDamage();
        } catch (SelfServiceDeviceBrokenException exception) {
            return Result.FAILURE;
        }
        return (cardDataBase.validateCard(card) ? Result.SUCCESS : Result.FAILURE);
    }

    @Override
    public Balance returnBalance(Card card) throws BankException, NoSuchProviderException, NoSuchAlgorithmException {
        try {
            checkForDamage();
            return (cardDataBase.getBalance(card));
        } catch (SelfServiceDeviceBrokenException exception) {
            throw exception;
        } catch (NotValidCardException | RepeatRequestOfBalanceException exception) {
            giveBackCard(card);
            throw exception;
        }
    }

    @Override
    public Result giveBackCard(Card card) throws NoSuchProviderException, NoSuchAlgorithmException {
        try {
            checkForDamage();
        } catch (SelfServiceDeviceBrokenException exception) {
            return Result.FAILURE;
        }
        return Result.SUCCESS;
    }

    @Override
    public void handleError(BankException exception) {
        cardDataBase.handleBankException(exception);
    }

    private void checkForDamage() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException {
        if (reliability.checkDeviceStatus() == DeviceStatus.BAD) {
            throw new SelfServiceDeviceBrokenException("I am out of order!");
        }
    }

}
