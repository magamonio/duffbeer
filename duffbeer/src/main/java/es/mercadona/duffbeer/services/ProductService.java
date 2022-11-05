package es.mercadona.duffbeer.services;

import es.mercadona.duffbeer.model.Product;
import es.mercadona.duffbeer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public Product getProductoById(Long id){
        return productRepository.findById(id).get();
    }

    public List<Product> getAllProductos(){
        return productRepository.findAll();
    }
}
