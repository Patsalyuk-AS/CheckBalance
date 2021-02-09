package com.github.patsalyukas.server.repository;

import com.github.patsalyukas.server.entities.BalanceEntity;
import com.github.patsalyukas.server.entities.BankCardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BalanceCrudRepository extends CrudRepository<BalanceEntity, Long> {

    Optional<BalanceEntity> findByCardID(BankCardEntity cardID);

}
