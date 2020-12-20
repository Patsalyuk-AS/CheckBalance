package com.github.patsalyukas.device;

import com.github.patsalyukas.outsideclasses.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ATMTest {

    private static Validator validator;
    private static CardDataBase<Card> dataBase;
    private static Card card;
    private static Balance balance;
    private static Address address;
    private static SelfServiceDevice selfServiceDevice;

    @BeforeAll
    public static void setUpValidator() throws IllegalCardParametersException {
        dataBase = new CardDataBase<>();
        balance = new Balance(Currency.RUB, new BigDecimal("15000"));
        address = new Address("Moscow area", "Moscow", "Pionerskaya", "100");
        card = BankCard.getInstance(new BankCardInfo("IVAN", "PETROV", "4256123542131234", "12/21", "652"), "1532", BankCardType.DEBET);
        selfServiceDevice = new ATM("100000", address, dataBase, new ReliabilityOfSelfServiceDevice(1000));
        DataBaseIninializer.initializeDataBase(dataBase);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void returnBalance() throws BankException, NoSuchProviderException, NoSuchAlgorithmException {
        assertEquals(balance, selfServiceDevice.returnBalance(card));
    }

    @Test
    void giveBackCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException {
        assertEquals(Result.SUCCESS, selfServiceDevice.giveBackCard(card));
    }


    @Test
    void getNumberATM() {
        ATM atm = new ATM(null, address, dataBase, new ReliabilityOfSelfServiceDevice(1000));
        Set<ConstraintViolation<ATM>> constraintViolations = validator.validate(atm);
        assertEquals("не должно равняться null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void getAddressATM() {
        ATM atm = new ATM("10000", null, dataBase, new ReliabilityOfSelfServiceDevice(1000));
        Set<ConstraintViolation<ATM>> constraintViolations = validator.validate(atm);
        assertEquals("не должно равняться null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void getCardDataBase() {
        ATM atm = new ATM("10000", address, null, new ReliabilityOfSelfServiceDevice(1000));
        Set<ConstraintViolation<ATM>> constraintViolations = validator.validate(atm);
        assertEquals("не должно равняться null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void getReliability() {
        ATM atm = new ATM("10000", address, dataBase, null);
        Set<ConstraintViolation<ATM>> constraintViolations = validator.validate(atm);
        assertEquals("не должно равняться null", constraintViolations.iterator().next().getMessage());
    }
}