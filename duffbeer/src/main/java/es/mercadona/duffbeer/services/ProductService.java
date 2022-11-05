package es.mercadona.duffbeer.services;

import es.mercadona.duffbeer.model.Product;
import es.mercadona.duffbeer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public List<Product> getProductosByCategoria(String categoria) {
        return productRepository.findByCategoria(categoria);
    }

    public List<Product> getProductosByMarca(String marca) {
        return productRepository.findByMarca(marca);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
    public void deleteAll(List<Long> ids) {
        productRepository.deleteAllById(ids);
    }

    public void wipeAllData() {
        productRepository.deleteAll();
    }

}
