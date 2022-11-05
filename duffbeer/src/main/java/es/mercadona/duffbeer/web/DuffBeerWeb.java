package es.mercadona.duffbeer.web;

import es.mercadona.duffbeer.model.Product;
import es.mercadona.duffbeer.repository.ProductRepository;
import es.mercadona.duffbeer.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class DuffBeerWeb {

    @Autowired
    private ProductService productService;

    @GetMapping("/welcome")
    public String welcome() {
        return "DuffBeer Api para el control de productos";
    }

    @PostMapping("/add")
    public List<Product> addProducts(@RequestBody Product... products){
        return productService.saveProducts(Arrays.stream(products).toList());
    }

    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable(value="id") Long id){
        return productService.getProductoById(id);
    }

    @GetMapping("/list")
    public List<Product> listProducts(){
        return productService.getAllProductos();
    }

}
