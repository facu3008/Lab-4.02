package com.ironhack.lab402.model;
import javax.validation.constraints.*;
import java.math.*;
import java.util.*;
public class MenuItem {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer year;

    public MenuItem(Integer id, String name, BigDecimal price, Integer year) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
