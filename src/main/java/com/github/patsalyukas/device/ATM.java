package com.github.patsalyukas.device;

import com.github.patsalyukas.outsideclasses.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ATM implements SelfServiceDevice {

    private int numberATM;
    private Address addressATM;
    private DataBaseServices dataBase;
    private Reliability reliability;

    @Override
    public Result takeCard(Card card) {
        try {
            checkForDamage();
        } catch (SelfServiceDeviceBrokenException exception) {
            return Result.FAILURE;
        }
        return (dataBase.validateCard(card) ? Result.SUCCESS : Result.FAILURE);
    }

    @Override
    public Balance returnBalance(Card card) throws BankException {
        try {
            checkForDamage();
            return (dataBase.getBalance(card));
        } catch (SelfServiceDeviceBrokenException | NotValidCardException | RepeatRequestOfBalanceException exception) {
            throw exception;
        }
    }

    @Override
    public Result giveBackCard(Card card) {
        try {
            checkForDamage();
        } catch (SelfServiceDeviceBrokenException exception) {
            return Result.FAILURE;
        }
        return Result.SUCCESS;
    }

    private void checkForDamage() throws SelfServiceDeviceBrokenException {
        if (reliability.checkDeviceStatus() == DeviceStatus.BAD) {
            throw new SelfServiceDeviceBrokenException("I am out of order!");
        }
    }

}
