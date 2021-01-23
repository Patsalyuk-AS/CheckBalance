package com.github.patsalyukas.services;

import com.github.patsalyukas.entities.BalanceEntity;
import com.github.patsalyukas.entities.BankCardEntity;
import com.github.patsalyukas.excepions.BalanceNotFoundException;
import com.github.patsalyukas.repository.BalanceCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BalanceService {

    private BalanceCrudRepository balanceCrudRepository;

    public BalanceEntity getBalance(BankCardEntity cardID) {
        return balanceCrudRepository.findByCardID(cardID).orElseThrow(BalanceNotFoundException::new);


    }

}
