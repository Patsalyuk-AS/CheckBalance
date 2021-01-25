package com.github.patsalyukas.server.outsideclasses;

import com.github.patsalyukas.common.utils.Currency;

import java.math.BigDecimal;
import java.util.function.BiPredicate;

public class DataBaseIninializer {

    private DataBaseIninializer() {
    }

    //вспомогательный метод для наполнения базы
    public static void initializeDataBase(CardDataBaseServices<Card> cardDataBase) throws IllegalCardParametersException {
        FactoryForCards<Card> factoryForCards = new BankCardFactory();
        BiPredicate<BankCardInfo, String> validator = CardValidator::validateCardParameters;
        cardDataBase.addCardToDataBase(factoryForCards.createCard(new BankCardInfo("IVAN", "PETROV", "4256123542131234", "12/21", "652"), "1532", BankCardType.DEBET, validator), factoryForCards.createBalance(Currency.RUB, new BigDecimal("15000")));
        cardDataBase.addCardToDataBase(factoryForCards.createCard(new BankCardInfo("PETR", "IVANOV", "4256123542134526", "30/12", "152"), "1020", BankCardType.DEBET, validator), factoryForCards.createBalance(Currency.RUB, new BigDecimal("30000")));
        cardDataBase.addCardToDataBase(factoryForCards.createCard(new BankCardInfo("SERGEY", "SIDOROV", "4256123542137536", "15/22", "752"), "2534", BankCardType.DEBET, validator), factoryForCards.createBalance(Currency.RUB, new BigDecimal("1000")));
        cardDataBase.addCardToDataBase(factoryForCards.createCard(new BankCardInfo("ELENA", "IVANOVA", "4256123542131526", "05/22", "632"), "8563", BankCardType.DEBET, validator), factoryForCards.createBalance(Currency.RUB, new BigDecimal("5000")));
        cardDataBase.addCardToDataBase(factoryForCards.createCard(new BankCardInfo("OXANA", "PETROVA", "4256123542131010", "24/22", "752"), "1145", BankCardType.DEBET, validator), factoryForCards.createBalance(Currency.RUB, new BigDecimal("4000")));
        cardDataBase.addCardToDataBase(factoryForCards.createCard(new BankCardInfo("SVETLANA", "SIDOROVA", "4256123542132233", "11/21", "156"), "5462", BankCardType.DEBET, validator), factoryForCards.createBalance(Currency.RUB, new BigDecimal("2000")));

    }

}
