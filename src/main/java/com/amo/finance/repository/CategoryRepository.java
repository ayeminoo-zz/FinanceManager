package com.amo.finance.repository;

import com.amo.finance.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ayeminoosc on 8/15/15.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
