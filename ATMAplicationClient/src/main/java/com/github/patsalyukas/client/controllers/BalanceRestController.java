package com.github.patsalyukas.client.controllers;

import com.github.patsalyukas.client.services.ATMClientService;
import com.github.patsalyukas.common.utils.BalanceDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class BalanceRestController {

    private ATMClientService atmClientService;

    @GetMapping("/balance")
    public BalanceDTO getBankCardBalance(@RequestParam String cardNumber) {
        log.info(String.format("Request of the balance of the card: %s", cardNumber));
        return atmClientService.getBankCardBalance(cardNumber);
    }


}
