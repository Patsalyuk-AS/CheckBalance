package com.github.patsalyukas.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BankCardDTO {

    private String cardNumber;
    private String pin;

}
