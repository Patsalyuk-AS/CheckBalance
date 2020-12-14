package com.github.patsalyukas.outsideclasses;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
public class CardDataBase<E extends Card> implements CardDataBaseServices<E> {

    private final Map<E, Balance> cards = new HashMap<>();
    private final Set<E> requestsOfBalances = new HashSet<>(20);

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
    public void getHistoryOfRequestsOfBalances() {
        requestsOfBalances.forEach(card -> log.info(card.toString()));
    }

    public void getCardsFromDataBase() {
        cards.forEach((k, v) -> log.info(k + " " + v));
    }

    @Override
    public void addCardToDataBase(E e, Balance balance) {
        cards.put(e, balance);
    }

    @Override
    public void handleBankException(BankException exception) {
        log.warn(exception.toString());
    }

    private void checkRepeatedRequestOfBalance(E e) throws RepeatRequestOfBalanceException {
        if (requestsOfBalances.contains(e)) {
            throw new RepeatRequestOfBalanceException("The request has already existed.");
        }
    }


}
