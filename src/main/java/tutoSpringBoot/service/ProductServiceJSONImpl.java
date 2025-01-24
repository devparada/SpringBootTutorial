package tutoSpringBoot.service;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import tutoSpringBoot.domain.Product;

@Service
@ConditionalOnProperty(name = "service.products", havingValue = "json")
public class ProductServiceJSONImpl implements ProductService {

    @Override
    public List<Product> getProducts() {
        List<Product> products;

        try {
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {
                            });

            return products;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
