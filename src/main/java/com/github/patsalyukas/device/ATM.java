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
            return (dataBase.validateCard(card) ? Result.SUCCESS : Result.FAILURE);
        } catch (SelfServiceDeviceBrokenException selfServiceDeviceBrokenException) {
            return Result.FAILURE;
        }
    }

    @Override
    public Balance returnBalance(Card card) throws SelfServiceDeviceBrokenException, NotValidCardException {
        try {
            checkForDamage();
            return (dataBase.getBalance(card));
        } catch (SelfServiceDeviceBrokenException selfServiceDeviceBrokenException) {
            throw new SelfServiceDeviceBrokenException("I am out of order!");
        } catch (NotValidCardException notValidCardException) {
            throw new NotValidCardException("The card is not valid!");
        }
    }

    @Override
    public Result giveBackCard(Card card) {
        try {
            checkForDamage();
            return Result.SUCCESS;
        } catch (SelfServiceDeviceBrokenException selfServiceDeviceBrokenException) {
            return Result.FAILURE;
        }
    }

    private void checkForDamage() throws SelfServiceDeviceBrokenException {
        if (reliability.checkDeviceStatus() == DeviceStatus.BAD) {
            throw new SelfServiceDeviceBrokenException("I am out of order!");
        }
    }

}
