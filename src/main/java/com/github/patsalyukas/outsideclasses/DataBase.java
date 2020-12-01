package com.github.patsalyukas.outsideclasses;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class DataBase implements DataBaseServices {

    private Map<Card, Balance> cards = new HashMap<>();
    private FactoryForCards factoryForCards;
    private Set<Card> requestsOfBalances = new HashSet<>(20);

    public DataBase(FactoryForCards factoryForCards) {
        this.factoryForCards = factoryForCards;
        cards.put(factoryForCards.createCard("4256123542131234", "12/21", "IVAN", "PETROV", 1532, 652, "DEBET"), factoryForCards.createBalance(Currency.RUB, new BigDecimal("15000")));
        cards.put(factoryForCards.createCard("4256123542134526", "30/22", "PETR", "IVANOV", 1020, 152, "DEBET"), factoryForCards.createBalance(Currency.RUB, new BigDecimal("30000")));
        cards.put(factoryForCards.createCard("4256123542137536", "15/22", "SERGEY", "SIDOROV", 2534, 752, "DEBET"), factoryForCards.createBalance(Currency.RUB, new BigDecimal("1000")));
        cards.put(factoryForCards.createCard("4256123542131526", "05/22", "ELENA", "IVANOVA", 8563, 632, "DEBET"), factoryForCards.createBalance(Currency.RUB, new BigDecimal("5000")));
        cards.put(factoryForCards.createCard("4256123542131010", "24/22", "OXANA", "PETROVA", 1145, 752, "DEBET"), factoryForCards.createBalance(Currency.RUB, new BigDecimal("4000")));
        cards.put(factoryForCards.createCard("4256123542132233", "11/21", "SVETLANA", "SIDOROVA", 5462, 156, "DEBET"), factoryForCards.createBalance(Currency.RUB, new BigDecimal("2000")));
    }

    @Override
    public boolean validateCard(Card card) {
        return cards.containsKey(card);
    }

    @Override
    public Balance getBalance(Card card) throws BankException {
        if (!validateCard(card)) {
            throw new NotValidCardException("The card is invalid!");
        }
        checkRepeatedRequestOfBalance(card);
        requestsOfBalances.add(card);
        return cards.get(card);

    }

    private void checkRepeatedRequestOfBalance(Card card) throws RepeatRequestOfBalanceException {
        if (requestsOfBalances.contains(card)) {
            throw new RepeatRequestOfBalanceException("The request has already existed.");
        }
    }

    @Override
    public void showHistoryOfRequestsOfBalances() {
        Stream<Card> cardStream = requestsOfBalances.stream();
        cardStream.forEach(System.out::println);
    }
}
