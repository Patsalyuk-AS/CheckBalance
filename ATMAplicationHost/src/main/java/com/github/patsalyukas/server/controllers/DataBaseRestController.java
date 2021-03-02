package com.github.patsalyukas.server.controllers;

import com.github.patsalyukas.common.utils.BalanceDTO;
import com.github.patsalyukas.common.utils.BankCardDTO;
import com.github.patsalyukas.server.entities.BankCardEntity;
import com.github.patsalyukas.server.services.BalanceService;
import com.github.patsalyukas.server.services.BankCardService;
import com.github.patsalyukas.server.services.CheckPinService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@AllArgsConstructor
public class DataBaseRestController {

    @NonNull BalanceService balanceService;
    @NonNull BankCardService bankCardService;
    @NonNull CheckPinService checkPinService;

    @PostMapping("/balance/{atmNumber}/{cardNumber}")
    public BalanceDTO getBalance(@PathVariable String atmNumber, @PathVariable String cardNumber, @RequestBody BankCardDTO bankCardDTO) {
        log.info(String.format("%s. ATM:%s. Request of the balance of the card: %s", LocalDateTime.now(), atmNumber, cardNumber));
        BankCardEntity bankCardEntity = bankCardService.getBankCard(cardNumber);
        checkPinService.checkPin(bankCardEntity, bankCardDTO);
        return balanceService.getBalance(bankCardEntity);
    }

}
