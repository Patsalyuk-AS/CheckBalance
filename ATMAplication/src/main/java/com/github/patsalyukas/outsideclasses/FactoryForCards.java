package com.github.patsalyukas.outsideclasses;

import java.math.BigDecimal;
import java.util.function.BiPredicate;

public interface FactoryForCards<E extends Card> {

    E createCard(BankCardInfo bankCardInfo, String pin, BankCardType type, BiPredicate<BankCardInfo, String> cardValidator) throws IllegalCardParametersException;

    Balance createBalance(Currency currency, BigDecimal sum);
}
