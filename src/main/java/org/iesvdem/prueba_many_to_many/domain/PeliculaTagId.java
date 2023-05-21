package org.iesvdem.prueba_many_to_many.domain;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PeliculaTagId implements Serializable {
    public long peliculaId;
    public long tagId;
}
