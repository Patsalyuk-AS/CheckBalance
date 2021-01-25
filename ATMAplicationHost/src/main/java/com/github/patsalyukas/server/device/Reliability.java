package com.github.patsalyukas.server.device;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface Reliability {

    DeviceStatus checkDeviceStatus() throws NoSuchProviderException, NoSuchAlgorithmException;

}
