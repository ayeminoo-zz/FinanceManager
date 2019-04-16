package com.amo.finance.repository;

import com.amo.finance.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * Created by ayeminoosc on 8/15/15.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByTimeBetween(Date from, Date to);
}
