package com.github.patsalyukas.client;

import com.github.patsalyukas.device.ATM;
import com.github.patsalyukas.device.ReliabilityOfSelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDeviceBrokenException;
import com.github.patsalyukas.outsideclasses.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class ATMClientTest {

    @Mock
    private final Moving moving = Mockito.mock(Moving.class);

    @Mock
    private final SelfServiceDevice ssdMock = Mockito.mock(SelfServiceDevice.class);

    private static Card card;
    private static Validator validator;
    private static Passport passport;
    private static SelfServiceDevice selfServiceDevice;

    @BeforeAll
    public static void setUp() throws IllegalCardParametersException {
        Address address = new Address("Moscow area", "Moscow", "Pionerskaya", "100");
        CardDataBase<Card> dataBase = new CardDataBase<>();
        passport = new Passport(7900, 156423, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1980, Month.FEBRUARY, 15), address);
        card = BankCard.getInstance(new BankCardInfo("IVAN", "PETROV", "4256123542131234", "12/21", "652"), "1532", BankCardType.DEBET);
        selfServiceDevice = new ATM("100000", address, dataBase, new ReliabilityOfSelfServiceDevice(1000));
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void goToSelfServiceDevice() {
        Mockito.when(moving.move(Wish.YES)).thenReturn(Result.SUCCESS);
        assertEquals(Result.SUCCESS, moving.move(Wish.YES));
        Mockito.when(moving.move(Wish.NO)).thenReturn(Result.FAILURE);
        assertEquals(Result.FAILURE, moving.move(Wish.NO));
    }

    @Test
    void insertCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException {
        Mockito.when(ssdMock.takeCard(card)).thenReturn(Result.SUCCESS);
        assertEquals(Result.SUCCESS, ssdMock.takeCard(card));
        Mockito.when(ssdMock.takeCard(card)).thenReturn(Result.FAILURE);
        assertEquals(Result.FAILURE, ssdMock.takeCard(card));
    }

    @Test
    void getBackCard() throws SelfServiceDeviceBrokenException, NoSuchProviderException, NoSuchAlgorithmException {
        Mockito.when(ssdMock.giveBackCard(card)).thenReturn(Result.SUCCESS);
        assertEquals(Result.SUCCESS, ssdMock.giveBackCard(card));
        Mockito.when(ssdMock.giveBackCard(card)).thenReturn(Result.FAILURE);
        assertEquals(Result.FAILURE, ssdMock.giveBackCard(card));
    }

    @Test
    void getPassport() {
        ATMClient atmClient = new ATMClient(null, selfServiceDevice, card);
        Set<ConstraintViolation<ATMClient>> constraintViolations = validator.validate(atmClient);
        assertEquals("must not be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void getSelfServiceDevice() {
        ATMClient atmClient = new ATMClient(passport, null, card);
        Set<ConstraintViolation<ATMClient>> constraintViolations = validator.validate(atmClient);
        assertEquals("must not be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void getCard() {
        ATMClient atmClient = new ATMClient(passport, selfServiceDevice, null);
        Set<ConstraintViolation<ATMClient>> constraintViolations = validator.validate(atmClient);
        assertEquals("must not be null", constraintViolations.iterator().next().getMessage());
    }
}