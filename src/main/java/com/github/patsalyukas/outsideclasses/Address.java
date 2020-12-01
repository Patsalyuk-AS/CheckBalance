package com.github.patsalyukas.outsideclasses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Address {

    private String region;
    private String city;
    private String street;
    private String house;
    private String flat;

    public Address(String region, String city, String street, String house) {
        this(region, city, street, house, "-");
    }


}
