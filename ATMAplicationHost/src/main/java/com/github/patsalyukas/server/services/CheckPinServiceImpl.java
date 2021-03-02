package com.github.patsalyukas.server.services;

import com.github.patsalyukas.common.utils.BankCardDTO;
import com.github.patsalyukas.server.entities.BankCardEntity;
import com.github.patsalyukas.server.excepions.InvalidPinException;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class CheckPinServiceImpl implements CheckPinService {

    public void checkPin(@NonNull BankCardEntity bankCardEntity, @NonNull BankCardDTO bankCardDTO) {
        if (!bankCardEntity.getPin().equals(bankCardDTO.getPin())) {
            throw new InvalidPinException();
        }
    }

}