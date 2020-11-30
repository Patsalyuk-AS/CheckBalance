package com.github.patsalyukas.outsideclasses;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class Balance {

    Currency currency;
    BigDecimal sum;

}
