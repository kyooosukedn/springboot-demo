package com.example.demo.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Techie {

    private int id;
    private String name;
    private int hoursOfWork;
    private int age;
    @Qualifier("laptop")
    private Laptop laptop;

    public Techie(int id, String name, int hoursOfWork, int age, Laptop laptop) {
        this.id = id;
        this.name = name;
        this.hoursOfWork = hoursOfWork;
        this.age = age;
        this.laptop = laptop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHoursOfWork() {
        return hoursOfWork;
    }

    public void setHoursOfWork(int hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
