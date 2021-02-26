package com.github.patsalyukas.server.controllers;

import com.github.patsalyukas.common.utils.BalanceDTO;
import com.github.patsalyukas.common.utils.BankCardDTO;
import com.github.patsalyukas.common.utils.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DataBaseRestControllerTest {

    @Autowired
    private DataBaseRestController dataBaseRestController;

    @Test
    void getBalance() {
        BalanceDTO balanceDTO = dataBaseRestController.getBalance("4256123542137536", new BankCardDTO("4256123542137536", "7412"));
        assertEquals(new BigDecimal("1000.50"), balanceDTO.getBalance());
        assertEquals(Currency.RUB, balanceDTO.getCurrency());
    }
}