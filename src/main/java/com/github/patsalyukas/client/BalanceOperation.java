package com.github.patsalyukas.client;

import com.github.patsalyukas.outsideclasses.Balance;
import com.github.patsalyukas.outsideclasses.BankException;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface BalanceOperation {

    Balance checkBalance() throws BankException, NoSuchProviderException, NoSuchAlgorithmException;

}
