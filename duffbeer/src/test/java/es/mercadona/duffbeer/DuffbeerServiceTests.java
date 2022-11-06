package es.mercadona.duffbeer;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.mercadona.duffbeer.model.Product;
import es.mercadona.duffbeer.model.Proveedor;
import es.mercadona.duffbeer.model.Seccion;
import es.mercadona.duffbeer.services.ProductService;
import es.mercadona.duffbeer.web.ProductosWebController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebMvcTest(ProductosWebController.class)
public class DuffbeerServiceTests
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService service;
    private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    public void listTest() throws Exception {
        List<Product> products = getProduct(true);


        when(service.getAllProductos()).thenReturn(products);

        this.mockMvc.perform(get("/list")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(products.get(0).getName())))
                .andExpect(jsonPath("$[0].seccion.name", is(products.get(0).getSeccion().getName())));
    }


    @Test
    public void badAddTest() throws Exception {
        this.mockMvc.perform(post("/add")).andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void addTest() throws Exception {
        List<Product> products = getProduct(true);

        when(service.saveProducts(products)).thenReturn(products);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/add")
                .content(objectMapper.writeValueAsString(products))
                .contentType(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk());

    }

    private List<Product> getProduct(boolean good) {
        Product product = new Product();
        product.setName("Coca-Cola");
        if(good){
            product.setPrice(1.2);
        }
        product.setSeccion(new Seccion());
        product.getSeccion().setName("Refrescos");
        product.setCreatedAt(new Date());
        Proveedor proveedor = new Proveedor();
        proveedor.setName("Coca Cola Company");
        proveedor.setTelefono("123456789");
        product.setProviders(Arrays.asList(proveedor));
        return Arrays.asList(product);
    }
}
