package es.mercadona.duffbeer.web;

import es.mercadona.duffbeer.model.Product;
import es.mercadona.duffbeer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class DuffBeerWeb {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/welcome")
    public String welcome() {
        return "DuffBeer Api para el control de productos";
    }

    @PostMapping("/add")
    public List<Product> addProduct(@RequestBody Product... products){
        return productRepository.saveAll(Arrays.stream(products).toList());
    }

    @GetMapping("/get/{id}")
    public Product addProduct(@PathVariable(value="id") Long id){
        return productRepository.findById(id).get();
    }

    @GetMapping("/list")
    public List<Product> addProduct(){
        return productRepository.findAll();
    }

}
