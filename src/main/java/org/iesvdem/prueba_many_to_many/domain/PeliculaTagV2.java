package org.iesvdem.prueba_many_to_many.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PeliculaTagV2 {
    @EmbeddedId
    PeliculaTagId id;

    @ManyToOne
    @MapsId("peliculaId")
    @JoinColumn(name = "id_pelicula", nullable = false)
    @ToString.Exclude
    PeliculaV2 pelicula;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("tagId")
    @JoinColumn(name = "id_tag", nullable = false)
    TagV2 tag;

}
