package com.github.patsalyukas.repository;

import com.github.patsalyukas.entities.BalanceEntity;
import com.github.patsalyukas.entities.BankCardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BalanceCrudRepository extends CrudRepository<BalanceEntity, Long> {

    Optional<BalanceEntity> findByCardID(BankCardEntity cardID);

}
