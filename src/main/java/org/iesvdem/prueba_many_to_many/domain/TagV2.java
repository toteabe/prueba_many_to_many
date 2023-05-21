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
public class TagV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String nombre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tag")
    @ToString.Exclude
    private List<PeliculaTagV2> peliculaTags = new ArrayList<>();

}
