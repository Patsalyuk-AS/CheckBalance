package com.github.patsalyukas.server.services;

import com.github.patsalyukas.server.entities.BankCardEntity;

public interface BankCardService {

    BankCardEntity getBankCard(String cardNumber);

}
