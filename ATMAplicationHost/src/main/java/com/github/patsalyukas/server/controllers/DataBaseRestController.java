package com.github.patsalyukas.server.controllers;

import com.github.patsalyukas.common.utils.BalanceDTO;
import com.github.patsalyukas.common.utils.BankCardDTO;
import com.github.patsalyukas.server.entities.BankCardEntity;
import com.github.patsalyukas.server.excepions.InvalidPinException;
import com.github.patsalyukas.server.services.BalanceService;
import com.github.patsalyukas.server.services.BankCardService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class DataBaseRestController {

    @NonNull BalanceService balanceService;
    @NonNull BankCardService bankCardService;

    @PostMapping("/balance/{cardNumber}")
    public BalanceDTO getBalance(@PathVariable String cardNumber, @RequestBody BankCardDTO bankCardDTO) {
        log.info(String.format("Request of the balance of the card: %s", cardNumber));
        BankCardEntity bankCardEntity = bankCardService.getBankCard(cardNumber);
        if (!bankCardDTO.getPin().equals(bankCardEntity.getPin())) {
            throw new InvalidPinException();
        }
        return balanceService.getBalance(bankCardEntity);
    }

}
