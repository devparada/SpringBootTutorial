package tutoSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tutoSpringBoot.domain.Product;
import tutoSpringBoot.service.ProductService;

@RestController
@RequestMapping("/productos")
public class ProductController {

    // Instancia de clase
    @Autowired
    private ProductService productsService;

    @GetMapping
    public ResponseEntity<?> getProducts() {
        List<Product> products = productsService.getProducts();

        return ResponseEntity.ok(products);
    }

}
