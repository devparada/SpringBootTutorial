package tutoSpringBoot.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tutoSpringBoot.domain.Product;
import tutoSpringBoot.service.ProductServiceImpl;
import tutoSpringBoot.service.ProductService;

@RestController
@RequestMapping("/productos")
public class ProductController {

    ProductService productsService = new ProductServiceImpl();

    @GetMapping
    public ResponseEntity<?> getProducts() {
        List<Product> products = productsService.getProducts();

        return ResponseEntity.ok(products);
    }

}
