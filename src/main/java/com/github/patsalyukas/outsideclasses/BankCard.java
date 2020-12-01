package com.github.patsalyukas.outsideclasses;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class BankCard implements Card {

    private String cardNumber;
    private String expDate;
    private String firstName;
    private String lastName;
    private int PIN;
    private int CVI;
    private String type;

    @Override
    public String getNumber() {
        return (getCardNumber());
    }

}
