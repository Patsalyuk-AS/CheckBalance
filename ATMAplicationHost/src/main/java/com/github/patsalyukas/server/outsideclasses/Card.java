package com.github.patsalyukas.server.outsideclasses;

public interface Card {

    BankCardInfo getCardInfo();

    String getPin();

    BankCardType getType();

}
