package com.github.patsalyukas.outsideclasses;

import java.math.BigDecimal;
import java.util.function.BiPredicate;

public class BankCardFactory implements FactoryForCards<Card> {

    @Override
    public Card createCard(BankCardInfo bankCardInfo, String pin, BankCardType type, BiPredicate<BankCardInfo, String> cardValidator) throws IllegalCardParametersException {
        if (!cardValidator.test(bankCardInfo, pin)) {
            throw new IllegalCardParametersException("Illegal card parameters!");
        }
        return BankCard.getInstance(bankCardInfo, pin, type);
    }

    @Override
    public Balance createBalance(Currency currency, BigDecimal sum) {
        return new Balance(currency, sum);
    }


}
