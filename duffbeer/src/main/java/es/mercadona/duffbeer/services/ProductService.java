package es.mercadona.duffbeer.services;

import es.mercadona.duffbeer.model.Product;
import es.mercadona.duffbeer.repository.ProductRepository;
import es.mercadona.duffbeer.repository.ProviderRepository;
import es.mercadona.duffbeer.repository.SeccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SeccionesRepository seccionesRepository;

    @Autowired
    private ProviderRepository providerRepository;

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Product getProductoById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getAllProductos() {
        return productRepository.findAll();
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

    public List<Product> getProductosBy(Product product) {
        Sort sort = Sort.by(Sort.Order.desc("seccion"), Sort.Order.desc("marca"), Sort.Order.asc("id"));
        return productRepository.findAll(Example.of(product), sort);
    }
}
