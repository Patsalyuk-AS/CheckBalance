package com.github.patsalyukas.client.controllers;

import com.github.patsalyukas.client.services.ATMClientService;
import com.github.patsalyukas.common.utils.BalanceDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class BalanceRestController {

    private ATMClientService atmClientService;

    @GetMapping("/balance/{cardNumber}")
    public BalanceDTO getBankCardBalance(@PathVariable String cardNumber) {
        return atmClientService.getBankCardBalance(cardNumber);
    }


}
