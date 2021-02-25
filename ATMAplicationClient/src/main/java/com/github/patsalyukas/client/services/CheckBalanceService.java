package com.github.patsalyukas.client.services;

import com.github.patsalyukas.common.utils.BalanceDTO;

import javax.validation.constraints.Pattern;

public interface CheckBalanceService {
    BalanceDTO getBankCardBalance(@Pattern(regexp = "^\\d{16}$") String cardNumber, @Pattern(regexp = "^\\d{4}$") String pin);

}
