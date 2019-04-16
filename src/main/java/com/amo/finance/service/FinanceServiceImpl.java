package com.amo.finance.service;

import com.amo.finance.entity.Category;
import com.amo.finance.entity.Transaction;
import com.amo.finance.repository.CategoryRepository;
import com.amo.finance.repository.TransactionRepository;
import com.amo.finance.util.CalendarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ayeminoosc on 8/15/15.
 */
@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Transaction> findWithinADay(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        return transactionRepository.findByTimeBetween(CalendarUtil.getStartTimeOfDay(calendar).getTime(),
                CalendarUtil.getEndTimeOfDay(calendar).getTime());
    }

    @Override
    public List<Transaction> findWithinAWeek(Date day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        return transactionRepository.findByTimeBetween(CalendarUtil.getStartTimeOfWeek(cal).getTime(),
                CalendarUtil.getEndTimeOfWeek(cal).getTime());
    }

    @Override
    public List<Transaction> findWithinAMonth(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        return transactionRepository.findByTimeBetween(CalendarUtil.getStartTimeOfMonth(calendar).getTime(),
                CalendarUtil.getEndTimeOfMonth(calendar).getTime());
    }

    @Override
    public List<Transaction> findWithinAYear(Date day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        return transactionRepository.findByTimeBetween(CalendarUtil.getStartTimeOfYear(cal).getTime(),
                CalendarUtil.getEndTimeOfYear(cal).getTime());
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void removeTransaction(Integer id) {
        transactionRepository.delete(id);
    }

    @Override
    public void removeCategory(Integer id) {
        categoryRepository.delete(id);

    }
}
