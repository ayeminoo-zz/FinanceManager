package com.amo.finance.repository;

import com.amo.finance.FinanceManagerApplication;
import com.amo.finance.entity.Category;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by ayeminoosc on 8/15/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FinanceManagerApplication.class)
@WebAppConfiguration
public class CategoryRepositoryTest extends TestCase {

    @Autowired
    private CategoryRepository categoryRepository;
    @Test
    public void find(){
        categoryRepository.save(new Category("description"));
        assertNotNull(categoryRepository.findAll());
    }

}