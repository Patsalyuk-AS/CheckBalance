package com.github.patsalyukas.outsideclasses;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Balance {

    Currency currency;
    BigDecimal sum;

}
