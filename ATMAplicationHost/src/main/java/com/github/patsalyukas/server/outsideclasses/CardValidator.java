package com.github.patsalyukas.server.outsideclasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidator {

    private static final Pattern patternCardNumber = Pattern.compile("^\\d{16}$");
    private static final Pattern patternPIN = Pattern.compile("^\\d{4}$");
    private static final Pattern patternCVI = Pattern.compile("^\\d{3}$");

    private CardValidator() {
    }

    public static boolean validateCardParameters(BankCardInfo bankCardInfo, String pin) {
        Matcher matcherCardNumber = patternCardNumber.matcher(bankCardInfo.getCardNumber());
        Matcher matcherPIN = patternPIN.matcher(pin);
        Matcher matcherCVI = patternCVI.matcher(bankCardInfo.getCvi());
        return (matcherCardNumber.matches() && matcherCVI.matches() && matcherPIN.matches());
    }

}
