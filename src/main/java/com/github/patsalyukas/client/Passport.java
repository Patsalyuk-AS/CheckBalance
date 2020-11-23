package com.github.patsalyukas.client;

import com.github.patsalyukas.outsideclasses.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Passport {

    private int serial;
    private int number;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthday;
    private Address address;

}
