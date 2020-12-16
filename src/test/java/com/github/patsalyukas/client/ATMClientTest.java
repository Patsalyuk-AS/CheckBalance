package com.github.patsalyukas.client;

import com.github.patsalyukas.device.SelfServiceDevice;
import com.github.patsalyukas.device.SelfServiceDeviceBrokenException;
import com.github.patsalyukas.outsideclasses.Card;
import com.github.patsalyukas.outsideclasses.Moving;
import com.github.patsalyukas.outsideclasses.Result;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class ATMClientTest {

    @Mock
    private final Moving moving = Mockito.mock(Moving.class);

    @Mock
    private final SelfServiceDevice ssdMock = Mockito.mock(SelfServiceDevice.class);

    Card card;

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

}