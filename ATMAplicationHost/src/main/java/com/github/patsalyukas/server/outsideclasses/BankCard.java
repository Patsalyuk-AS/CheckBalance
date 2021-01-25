package com.github.patsalyukas.server.outsideclasses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class BankCard implements Card {

    private final BankCardInfo cardInfo;
    private final String pin;
    private final BankCardType type;

    private BankCard(BankCardInfo cardInfo, String pin, BankCardType type) {
        this.cardInfo = cardInfo;
        this.pin = pin;
        this.type = type;
    }

    public static BankCard getInstance(BankCardInfo cardInfo, String pin, BankCardType type) throws IllegalCardParametersException {
        if (!CardValidator.validateCardParameters(cardInfo, pin)) {
            throw new IllegalCardParametersException("Card parameters are wrong!");
        }
        return new BankCard(cardInfo, pin, type);
    }
}
