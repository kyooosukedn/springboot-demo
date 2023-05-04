package com.example.demo.autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Laptop {
    private int id;
    private String name;

    public void show() {
        System.out.println("show something..object created");
    }
}

