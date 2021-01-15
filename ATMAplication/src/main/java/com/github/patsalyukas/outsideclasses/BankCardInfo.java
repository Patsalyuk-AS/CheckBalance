package com.github.patsalyukas.outsideclasses;

import lombok.Value;

@Value
public class BankCardInfo {

    private final String firstName;
    private final String lastName;
    private final String cardNumber;
    private final String expDate;
    private final String cvi;

}
