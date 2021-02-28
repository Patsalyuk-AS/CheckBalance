package com.github.patsalyukas.server.entities;

import com.github.patsalyukas.common.utils.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Balances")
@NoArgsConstructor
@Getter
@Setter
public class BalanceEntity {

    @Id
    @GeneratedValue
    private long id;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToOne
    @JoinColumn(name = "card_id", nullable = false)
    private BankCardEntity cardID;

}
