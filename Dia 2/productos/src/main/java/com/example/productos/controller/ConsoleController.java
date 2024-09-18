package com.example.productos.controller;

import com.example.productos.model.Product;
import com.example.productos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ConsoleController {

    @Autowired
    private ProductService productService;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("");
            System.out.println("1. Añadir producto");
            System.out.println("");
            System.out.println("2. Ver productos");
            System.out.println("3. Ver producto por ID");
            System.out.println("4. Eliminar producto por ID");
            System.out.println("5. Salir");
            System.out.println("");
            System.out.print("Ingresa una opcion: ");
            System.out.println("");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    listProducts();
                    break;
                case 3:
                    getProductById(scanner);
                    break;
                case 4:
                    deleteProductById(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("");
                    System.out.println("Opción inválida");
            }
        }
        scanner.close();
    }

    private void addProduct(Scanner scanner) {
        System.out.println("");
        System.out.print("Ingresa el ID del producto: ");
        Long id = scanner.nextLong();
        System.out.println("");
        System.out.print("Ingresa el nombre del producto: ");
        String name = scanner.next();
        System.out.println("");
        System.out.print("Ingresa el precio del producto: ");
        double price = scanner.nextDouble();
        Product product = new Product(id, name, price);
        productService.addProduct(product);
        System.out.println("");
        System.out.println("Producto añadido con éxito!!!!");
    }

    private void listProducts() {
        productService.getAllProducts().forEach(System.out::println);
    }

    private void getProductById(Scanner scanner) {
        System.out.print("Ingresa el ID del producto: ");
        Long id = scanner.nextLong();
        System.out.println("");
        Product product = productService.getProductById(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Producto no encontrado.");
            System.out.println("");
        }
    }

    private void deleteProductById(Scanner scanner) {
        System.out.print("Ingresa el ID del producto ");
        Long id = scanner.nextLong();
        System.out.println("");
        productService.deleteProductById(id);
        System.out.println("Producto eliminado correctamente.");
        System.out.println("");
    }
}
