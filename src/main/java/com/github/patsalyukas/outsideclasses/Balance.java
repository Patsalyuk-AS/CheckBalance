package com.github.patsalyukas.outsideclasses;

import lombok.*;

import java.math.BigInteger;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Balance {

    Currency currency;
    BigInteger sum;

}
