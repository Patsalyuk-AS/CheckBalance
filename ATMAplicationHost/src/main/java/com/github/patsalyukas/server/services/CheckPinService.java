package com.github.patsalyukas.server.services;

import com.github.patsalyukas.common.utils.BankCardDTO;
import com.github.patsalyukas.server.entities.BankCardEntity;
import lombok.NonNull;

public interface CheckPinService {

    void checkPin(@NonNull BankCardEntity bankCardEntity, @NonNull BankCardDTO bankCardDTO);

}