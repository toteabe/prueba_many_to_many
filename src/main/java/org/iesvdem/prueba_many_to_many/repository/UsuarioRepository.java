package org.iesvdem.prueba_many_to_many.repository;


import org.iesvdem.prueba_many_to_many.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
