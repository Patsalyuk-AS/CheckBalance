package com.github.patsalyukas.outsideclasses;

public interface Card {

    BankCardInfo getCardInfo();

    String getPin();

    BankCardType getType();

}
