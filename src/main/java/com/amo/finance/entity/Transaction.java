package com.amo.finance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by ayeminoosc on 8/15/15.
 */
@Entity
public class Transaction extends BaseEntity{
    private double amount;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private Date time;

    public Transaction(){

    }

    public Transaction(double amount, String description, Category category, Date time) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
