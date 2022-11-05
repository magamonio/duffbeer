package es.mercadona.duffbeer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "marca")
    private String marca;

    @Getter
    @Setter
    @Column(name = "categoria")
    private String categoria;

    @Getter
    @Setter
    @Column(name = "price", nullable = false)
    private Double price;

    @Override
    public String toString(){
        return String.format("%d: %s, %s\t%d", id, name, marca, price);
    }

}
