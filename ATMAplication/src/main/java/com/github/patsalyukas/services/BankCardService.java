package com.github.patsalyukas.services;

import com.github.patsalyukas.entities.BankCardEntity;
import com.github.patsalyukas.excepions.CardNotFoundException;
import com.github.patsalyukas.repository.BankCardCrudRepository;
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
