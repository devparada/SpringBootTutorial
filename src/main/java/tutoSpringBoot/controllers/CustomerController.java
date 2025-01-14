package tutoSpringBoot.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tutoSpringBoot.domain.Customer;

@RestController
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo López", "gerardol", "contrasena123"),
            new Customer(456, "Alejandra García", "alegarcia", "clave456"),
            new Customer(789, "Laura Sanchéz", "lauras", "secreto789"),
            new Customer(234, "Carlos Martínez", "carlosm", "password234")));

    @GetMapping("clientes")
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("clientes/{username}")
    public Customer getCliente(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }

}
