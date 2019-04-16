package com.amo.finance.repository;

import com.amo.finance.FinanceManagerApplication;
import com.amo.finance.entity.Category;
import com.amo.finance.entity.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by ayeminoosc on 8/15/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FinanceManagerApplication.class)
@WebAppConfiguration
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;
    Calendar calendar = Calendar.getInstance();

    @Before
    public void setUp(){
        calendar.set(Calendar.HOUR_OF_DAY, 2);
        Transaction t1 = new Transaction(100, "T1", new Category("C1"), calendar.getTime());
        System.out.println(calendar.getTime());
        transactionRepository.save(t1);
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        transactionRepository.save(new Transaction(200, "T2", new Category("C2"), calendar.getTime()));
    }

    @Test
    public void testFindByTimeBetween() throws Exception {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        Date start = calendar.getTime();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        Date end = calendar.getTime();
        assertEquals(2, transactionRepository.findByTimeBetween(start, end).size());

    }
}