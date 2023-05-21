package org.iesvdem.prueba_many_to_many.repository;

import org.iesvdem.prueba_many_to_many.domain.Pelicula;
import org.iesvdem.prueba_many_to_many.domain.PeliculaV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaV2Repository extends JpaRepository<PeliculaV2, Long> {

}
