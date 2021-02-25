package com.github.patsalyukas.client.controllers;

import com.github.patsalyukas.client.services.CheckBalanceService;
import com.github.patsalyukas.common.utils.BalanceDTO;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BalanceRestController {


    @NonNull
    private CheckBalanceService checkBalanceService;

    @GetMapping("/balance")
    public BalanceDTO getBankCardBalance(@RequestParam String cardNumber, @RequestParam String pin) {
        return checkBalanceService.getBankCardBalance(cardNumber, pin);
    }


}
