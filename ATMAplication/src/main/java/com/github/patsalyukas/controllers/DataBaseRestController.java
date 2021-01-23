package com.github.patsalyukas.controllers;

import com.github.patsalyukas.dto.BalanceDTO;
import com.github.patsalyukas.entities.BalanceEntity;
import com.github.patsalyukas.services.BalanceService;
import com.github.patsalyukas.services.BankCardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DataBaseRestController {

    private BalanceService balanceService;
    private BankCardService bankCardService;

    @GetMapping("/balance/{cardNumber}")
    public BalanceDTO getBalance(@PathVariable String cardNumber) {
        BalanceEntity balanceEntity = balanceService.getBalance(bankCardService.getBankCard(cardNumber));
        return new BalanceDTO(balanceEntity.getBalance(), balanceEntity.getCurrency());
    }

}
