package com.github.patsalyukas.server.entities;

import com.github.patsalyukas.server.outsideclasses.BankCardType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Bankcards")
@NoArgsConstructor
@Getter
@Setter
public class BankCardEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "exp_date")
    private String expDate;

    private String cvi;

    private String pin;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private BankCardType bankCardType;

}
