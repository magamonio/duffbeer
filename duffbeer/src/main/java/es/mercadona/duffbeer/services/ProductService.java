package es.mercadona.duffbeer.services;

import es.mercadona.duffbeer.model.Product;
import es.mercadona.duffbeer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
    public void deleteAll(List<Long> ids) {
        productRepository.deleteAllById(ids);
    }

    public void wipeAllData() {
        productRepository.deleteAll();
    }

    public List<Product> getProductosBy(Map<String, String> map) {
        Product p = new Product();
        p.setCategoria(map.get("categoria"));
        p.setMarca(map.get("marca"));
        Sort sort = Sort.by(Sort.Order.desc("categoria"), Sort.Order.desc("marca"), Sort.Order.asc("id"));
        return productRepository.findAll(Example.of(p), sort);
    }
}
