package org.iesvdem.prueba_many_to_many.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String titulo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pelicula", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PeliculaTag> peliculaTags = new ArrayList<>();

}