package com.github.patsalyukas.server.repository;

import com.github.patsalyukas.server.entities.BankCardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankCardCrudRepository extends CrudRepository<BankCardEntity, Long> {

    Optional<BankCardEntity> findByCardNumber(String cardNumber);

}
