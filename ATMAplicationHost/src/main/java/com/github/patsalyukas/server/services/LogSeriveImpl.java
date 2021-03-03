package com.github.patsalyukas.server.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class LogSeriveImpl implements LogService{

    @Override
    public void writeLog(String atmNumber, String cardNumber) {
        log.info(String.format("%s. ATM:%s. Request of the balance of the card: %s", LocalDateTime.now(), atmNumber, cardNumber));
    }
}
