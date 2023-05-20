package org.iesvdem.prueba_many_to_many.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    long id;

    String nombre;


    //Lado maestro: puesto que tengo cascade de PERSITS (salvar primera vez) y MERGE (actualizar siguientes veces con cambios)
    //si quiero guardar usuarios con roles por primera vez
    @ManyToMany( fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Rol> roles = new HashSet<>();

}
