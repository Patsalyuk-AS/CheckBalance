package com.github.patsalyukas.server.services;

import com.github.patsalyukas.server.entities.BankCardEntity;
import com.github.patsalyukas.server.excepions.CardNotFoundException;
import com.github.patsalyukas.server.repository.BankCardCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankCardService {

    private BankCardCrudRepository bankCardCrudRepository;

    public BankCardEntity getBankCard(String cardNumber) {
        return bankCardCrudRepository.findByCardNumber(cardNumber).orElseThrow(CardNotFoundException::new);
    }
}
