package com.github.patsalyukas.server.client;

import com.github.patsalyukas.server.outsideclasses.Address;
import lombok.Value;

import java.time.LocalDate;

@Value
public class Passport {

    private final int serial;
    private final int number;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final LocalDate birthday;
    private final Address address;

}
