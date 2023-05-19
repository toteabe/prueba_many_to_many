package org.iesvdem.prueba_many_to_many.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    long id;

    String nombre;

    //Lado esclavo: no puedo persistir usuarios de la coleccion a través de la persistencia de rol.
    @ManyToMany(
            mappedBy = "roles")
    Set<Usuario> usuarios = new HashSet<>();

}
