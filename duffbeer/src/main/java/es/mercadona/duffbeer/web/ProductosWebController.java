package es.mercadona.duffbeer.web;

import es.mercadona.duffbeer.model.Product;
import es.mercadona.duffbeer.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductosWebController {

    @Autowired
    private ProductService productService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Productos Api para el control de productos";
    }

    @PostMapping("/add")
    public List<Product> addProducts(@RequestBody Product... products){
        return productService.saveProducts(Arrays.stream(products).toList());
    }

    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable(value="id") Long id){
        return productService.getProductoById(id);
    }

    @GetMapping("/findBy")
    public List<Product> findProductsBy(@RequestBody Product product){
        return productService.getProductosBy(product);
    }

    @GetMapping("/list")
    public List<Product> listProducts(){
        return productService.getAllProductos();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(value="id") Long id){
        productService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteById(@RequestBody Long... ids){
        productService.deleteAll(Arrays.stream(ids).toList());
    }

    @DeleteMapping("/wipeAllData")
    public String wipeAllData(){
        productService.wipeAllData();
        return "Se han eliminado todos los productos.";
    }


}
