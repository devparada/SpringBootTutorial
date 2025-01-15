package tutoSpringBoot.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tutoSpringBoot.domain.Customer;

@RestController
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo López", "gerardol", "contrasena123"),
            new Customer(456, "Alejandra García", "alegarcia", "clave456"),
            new Customer(789, "Laura Sanchéz", "lauras", "secreto789"),
            new Customer(234, "Carlos Martínez", "carlosm", "password234")));

    @GetMapping("/clientes")
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("/clientes/{username}")
    public Customer getCliente(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }

    @PostMapping("/clientes")
    public Customer postCliente(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    @PutMapping("/clientes")
    public Customer putCliente(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/clientes/{id}")
    public Customer deleteCliente(@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getID() == id) {
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    @PatchMapping("/clientes")
    public Customer patchCliente(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {
                if (customer.getName() != null) {
                    c.setName(customer.getName());
                }
                if (customer.getUsername() != null) {
                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }
                return c;
            }
        }
        return null;
    }

}
