package com.github.patsalyukas.server.services;

import com.github.patsalyukas.server.entities.BankCardEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class BankCardServiceImplTest {

    @Autowired
    private BankCardService bankCardService;

    @Test
    void getBankCard() {
        BankCardEntity bankCardEntity = bankCardService.getBankCard("4256123542134526");
        assertNotNull(bankCardEntity);
        assertEquals("4521", bankCardEntity.getPin());
        assertEquals("PETROV", bankCardEntity.getLastName());
    }
}