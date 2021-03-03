package com.github.patsalyukas.client.services;

import com.github.patsalyukas.common.utils.BalanceDTO;
import com.github.patsalyukas.common.utils.BankCardDTO;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Pattern;

@Service
@Validated
public class CheckBalanceServiceImpl implements CheckBalanceService {

    @Override
    public BalanceDTO getBankCardBalance(@Pattern(regexp = "^\\d{16}$") String cardNumber, @Pattern(regexp = "^\\d{4}$") String pin, String atmNumber) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<BankCardDTO> request = new HttpEntity<>(new BankCardDTO(cardNumber, pin));
        return restTemplate.postForObject(String.format("http://localhost:8080/balance/%s/%s", atmNumber, cardNumber), request, BalanceDTO.class);
    }

}
