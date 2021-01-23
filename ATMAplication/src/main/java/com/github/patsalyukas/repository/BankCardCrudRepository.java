package com.github.patsalyukas.repository;

import com.github.patsalyukas.entities.BankCardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankCardCrudRepository extends CrudRepository<BankCardEntity, Long> {

    Optional<BankCardEntity> findByCardNumber(String cardNumber);

}
