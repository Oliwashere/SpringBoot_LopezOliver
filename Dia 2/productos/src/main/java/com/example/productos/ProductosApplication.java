package com.example.productos;

import com.example.productos.controller.ConsoleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductosApplication implements CommandLineRunner {

    @Autowired
    private ConsoleController consoleController;

    public static void main(String[] args) {
        SpringApplication.run(ProductosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        consoleController.start();
    }
}