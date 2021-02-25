package com.github.patsalyukas.server.services;

import com.github.patsalyukas.common.utils.BalanceDTO;
import com.github.patsalyukas.server.entities.BankCardEntity;

public interface BalanceService {

    BalanceDTO getBalance(BankCardEntity cardID);

}
