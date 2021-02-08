package com.github.patsalyukas.client.services;

import com.github.patsalyukas.common.utils.BalanceDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Pattern;

@Service
public class ATMClientService {

    public BalanceDTO getBankCardBalance(@Pattern(regexp = "\\d{16}$") String cardNumber) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/balance/" + cardNumber, BalanceDTO.class);
    }

}
