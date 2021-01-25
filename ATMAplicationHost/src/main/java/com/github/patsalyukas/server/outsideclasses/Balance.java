package com.github.patsalyukas.server.outsideclasses;

import com.github.patsalyukas.common.utils.Currency;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class Balance {

    private final Currency currency;
    private final BigDecimal sum;

}
