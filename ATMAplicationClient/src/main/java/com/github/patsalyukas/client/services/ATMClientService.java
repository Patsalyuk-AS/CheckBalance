package com.github.patsalyukas.client.services;

import com.github.patsalyukas.common.utils.BalanceDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ATMClientService {

    public BalanceDTO getBankCardBalance(String cardNumber) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/balance/" + cardNumber, BalanceDTO.class);
    }

}
