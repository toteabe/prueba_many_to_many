package org.iesvdem.prueba_many_to_many;

import org.iesvdem.prueba_many_to_many.domain.*;
import org.iesvdem.prueba_many_to_many.repository.DBRepository;
import org.iesvdem.prueba_many_to_many.repository.PeliculaRepository;
import org.iesvdem.prueba_many_to_many.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PruebaManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaManyToManyApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DBRepository dbRepository, UsuarioRepository usuarioRepository, PeliculaRepository peliculaRepository) {

		return (args) -> {

			int elminados = dbRepository.truncateAllTablesInDatabase();
			System.out.println(elminados);

			//Prueba ManyToMany unidireccional
			Usuario usuario = new Usuario();
			usuario.setNombre("root");

			Rol rol = new Rol();
			rol.setNombre("ADMIN");
			Rol rol2 = new Rol();
			rol2.setNombre("USER");

			usuario.getRoles().add(rol);
			usuario.getRoles().add(rol2);

			usuario = usuarioRepository.save(usuario);

			System.out.println(usuarioRepository.findById(usuario.getId()).orElse(null));

			//Prueba ManyToMany mediante 2 OneToMany bidereccionales
			Pelicula pelicula = new Pelicula();
			pelicula.setTitulo("Indiana Jones");

			Tag tag = new Tag();
			tag.setNombre("Aventuras");

			PeliculaTag peliculaTag = new PeliculaTag(0, pelicula, tag);

			Tag tag2 = new Tag();
			tag2.setNombre("Acción");

			PeliculaTag peliculaTag2 = new PeliculaTag(0, pelicula, tag2);

			Tag tag3 = new Tag();
			tag3.setNombre("Comedia");

			PeliculaTag peliculaTag3 = new PeliculaTag(0, pelicula, tag2);

			pelicula.getPeliculaTags().add(peliculaTag);
			pelicula.getPeliculaTags().add(peliculaTag2);
			pelicula.getPeliculaTags().add(peliculaTag3);

			pelicula = peliculaRepository.save(pelicula);

			System.out.println(peliculaRepository.findById(pelicula.getId()).orElse(null));

		};

	}

}
