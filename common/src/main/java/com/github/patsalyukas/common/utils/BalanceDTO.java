package com.github.patsalyukas.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BalanceDTO {

    private BigDecimal balance;
    private Currency currency;

    //без конструктора по умолчанию выкидывает ошибку
    //com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.github.patsalyukas.common.utils.BalanceDTO`
    //(no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
    //Решение - https://facingissuesonit.com/2019/07/17/com-fasterxml-jackson-databind-exc-invaliddefinitionexception-cannot-construct-instance-of-xyz-no-creators-like-default-construct-exist-cannot-deserialize-from-object-value-no-delega/


}
