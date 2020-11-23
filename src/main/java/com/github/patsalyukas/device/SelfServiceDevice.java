package com.github.patsalyukas.device;

import com.github.patsalyukas.outsideclasses.Balance;
import com.github.patsalyukas.outsideclasses.Card;
import com.github.patsalyukas.outsideclasses.NotValidCardException;
import com.github.patsalyukas.outsideclasses.Result;

public interface SelfServiceDevice {

    Result takeCard(Card card) throws SelfServiceDeviceBrokenException;

    Balance returnBalance(Card card) throws SelfServiceDeviceBrokenException, NotValidCardException;

    Result giveBackCard(Card card) throws SelfServiceDeviceBrokenException;

}
