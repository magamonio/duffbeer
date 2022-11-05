package es.mercadona.duffbeer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "providers")
public class Proveedor {

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
    @Column(name = "telefono")
    private String telefono;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "providers")
    @JsonIgnore
    private Set<Product> products;
}
