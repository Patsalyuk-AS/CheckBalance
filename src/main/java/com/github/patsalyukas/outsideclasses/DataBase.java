package com.github.patsalyukas.outsideclasses;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Slf4j
public class DataBase<E extends Card> implements DataBaseServices<E> {

    private Map<Card, Balance> cards = new HashMap<>();
    private final FactoryForCards factoryForCards;
    private Set<E> requestsOfBalances = new HashSet<>(20);

    public DataBase(FactoryForCards factoryForCards) {
        this.factoryForCards = factoryForCards;
        inializeDataBase();
    }

    @Override
    public boolean validateCard(E e) {
        return cards.containsKey(e);
    }

    @Override
    public Balance getBalance(E e) throws BankException {
        if (!validateCard(e)) {
            throw new NotValidCardException("The card is invalid!");
        }
        checkRepeatedRequestOfBalance(e);
        requestsOfBalances.add(e);
        return cards.get(e);

    }

    @Override
    public void showHistoryOfRequestsOfBalances() {
        Stream<E> cardStream = requestsOfBalances.stream();
        cardStream.forEach(System.out::println);
    }

    @Override
    public void addCardToDataBase(String cardNumber, String expDate, String firstName, String lastName, int PIN, int CVI, BankCardType type, Currency currency, BigDecimal sum) {
        cards.put(factoryForCards.createCard(cardNumber, expDate, firstName, lastName, PIN, CVI, type), factoryForCards.createBalance(currency, sum));
    }

    @Override
    public void handleBankException(BankException exception) {
        log.warn(exception.toString());
        System.out.println(exception.getMessage());
    }

    private void checkRepeatedRequestOfBalance(E e) throws RepeatRequestOfBalanceException {
        if (requestsOfBalances.contains(e)) {
            throw new RepeatRequestOfBalanceException("The request has already existed.");
        }
    }

    private void inializeDataBase() {
        addCardToDataBase("4256123542131234", "12/21", "IVAN", "PETROV", 1532, 652, BankCardType.DEBET, Currency.RUB, new BigDecimal("15000"));
        addCardToDataBase("4256123542134526", "30/22", "PETR", "IVANOV", 1020, 152, BankCardType.DEBET, Currency.RUB, new BigDecimal("30000"));
        addCardToDataBase("4256123542137536", "15/22", "SERGEY", "SIDOROV", 2534, 752, BankCardType.DEBET, Currency.RUB, new BigDecimal("1000"));
        addCardToDataBase("4256123542131526", "05/22", "ELENA", "IVANOVA", 8563, 632, BankCardType.DEBET, Currency.RUB, new BigDecimal("5000"));
        addCardToDataBase("4256123542131010", "24/22", "OXANA", "PETROVA", 1145, 752, BankCardType.DEBET, Currency.RUB, new BigDecimal("4000"));
        addCardToDataBase("4256123542132233", "11/21", "SVETLANA", "SIDOROVA", 5462, 156, BankCardType.DEBET, Currency.RUB, new BigDecimal("2000"));
    }

}
