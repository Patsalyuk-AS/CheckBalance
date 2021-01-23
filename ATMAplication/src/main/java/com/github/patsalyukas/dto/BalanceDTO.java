package com.github.patsalyukas.dto;

import com.github.patsalyukas.outsideclasses.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class BalanceDTO {

    private BigDecimal balance;
    private Currency currency;

}
