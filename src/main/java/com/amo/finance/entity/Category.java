package com.amo.finance.entity;

import javax.persistence.*;

/**
 * Created by ayeminoosc on 8/15/15.
 */
@Entity
@Table(name="T_CATEGORY")
public class Category extends BaseEntity{

    @Column(name = "C_DESCRIPTION")
    private String description;

    public Category(){

    }
    public Category(String description){
        this.description = description;
    }
//    private Type type;
//    private byte[]icon;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Type getType() {
//        return type;
//    }

//    public void setType(Type type) {
//        this.type = type;
//    }

//    public byte[] getIcon() {
//        return icon;
//    }

//    public void setIcon(byte[] icon) {
//        this.icon = icon;
//    }
}
