package com.github.patsalyukas.server.services;

import com.github.patsalyukas.common.utils.BalanceDTO;
import com.github.patsalyukas.server.entities.BankCardEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class BalanceServiceImplTest {

    @Autowired
    private BalanceService balanceService;
    @Autowired
    private BankCardService bankCardService;

    @Test
    void getBalance() {
        BankCardEntity bankCardEntity = bankCardService.getBankCard("4256123542131234");
        BalanceDTO balanceDTO = balanceService.getBalance(bankCardEntity);
        assertEquals(new BigDecimal("1500"), balanceDTO.getBalance());
    }
}