package ma.emsi.schoolapp.web;

import ma.emsi.schoolapp.Repository.ProductRepository;
import ma.emsi.schoolapp.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }
}

