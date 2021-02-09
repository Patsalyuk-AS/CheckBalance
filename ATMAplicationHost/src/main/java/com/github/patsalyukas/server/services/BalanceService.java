package com.github.patsalyukas.server.services;

import com.github.patsalyukas.common.utils.BalanceDTO;
import com.github.patsalyukas.server.entities.BalanceEntity;
import com.github.patsalyukas.server.entities.BankCardEntity;
import com.github.patsalyukas.server.excepions.BalanceNotFoundException;
import com.github.patsalyukas.server.repository.BalanceCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BalanceService {

    private BalanceCrudRepository balanceCrudRepository;

    public BalanceDTO getBalance(BankCardEntity cardID) {
        BalanceEntity balanceEntity = balanceCrudRepository.findByCardID(cardID).orElseThrow(BalanceNotFoundException::new);
        return new BalanceDTO(balanceEntity.getBalance(), balanceEntity.getCurrency());
    }

}
