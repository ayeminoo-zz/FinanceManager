package com.amo.finance.service;

import com.amo.finance.entity.Category;
import com.amo.finance.entity.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by ayeminoosc on 8/15/15.
 */
public interface FinanceService {
    public List<Category> findAll();
    public List<Transaction> findWithinADay(Date day);
    public List<Transaction> findWithinAWeek(Date day);
    public List<Transaction> findWithinAMonth(Date day);
    public List<Transaction> findWithinAYear(Date day);
    public void saveTransaction(Transaction transaction);
    public void saveCategory(Category category);
    public void removeTransaction(Integer id);
    public void removeCategory(Integer id);
}
