package com.github.patsalyukas.server.controllers;

import com.github.patsalyukas.common.utils.BalanceDTO;
import com.github.patsalyukas.server.services.BalanceService;
import com.github.patsalyukas.server.services.BankCardService;
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
        return balanceService.getBalance(bankCardService.getBankCard(cardNumber));
    }

}
