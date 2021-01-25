package com.github.patsalyukas.server.client;

import com.github.patsalyukas.server.outsideclasses.Balance;
import com.github.patsalyukas.server.outsideclasses.BankException;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface BalanceOperation {

    Balance checkBalance() throws BankException, NoSuchProviderException, NoSuchAlgorithmException;

}
