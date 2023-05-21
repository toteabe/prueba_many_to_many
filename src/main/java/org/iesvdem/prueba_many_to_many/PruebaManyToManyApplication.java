package org.iesvdem.prueba_many_to_many;

import org.iesvdem.prueba_many_to_many.domain.*;
import org.iesvdem.prueba_many_to_many.repository.DBRepository;
import org.iesvdem.prueba_many_to_many.repository.PeliculaRepository;
import org.iesvdem.prueba_many_to_many.repository.PeliculaV2Repository;
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
	CommandLineRunner runner(DBRepository dbRepository, UsuarioRepository usuarioRepository, PeliculaRepository peliculaRepository, PeliculaV2Repository peliculaV2Repository) {

		return (args) -> {

			int elminados = dbRepository.truncateAllTablesInDatabase();
			System.out.println(elminados);

			//Prueba ManyToMany unidireccional
			pruebaUsuarioRol(usuarioRepository);

			//Prueba ManyToMany mediante 2 OneToMany bidereccionales
			//pruebaManyToMany2OneToMany(peliculaRepository);

			//Prueba ManyToMany mediante 2 OneToMany bidereccionales con clave compuesta
			pruebaManyToMany2OneToManyClaveCompuesta(peliculaV2Repository);

		};

	}

	static void pruebaUsuarioRol(UsuarioRepository usuarioRepository) {
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
	}

	static void pruebaManyToMany2OneToMany(PeliculaRepository peliculaRepository) {

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

	}

	static void pruebaManyToMany2OneToManyClaveCompuesta(PeliculaV2Repository peliculaRepository) {

		PeliculaV2 pelicula = new PeliculaV2();
		pelicula.setTitulo("Apocalypse Now");

		TagV2 tag = new TagV2();
		tag.setNombre("Bélica");

		PeliculaTagV2 peliculaTag = new PeliculaTagV2(new PeliculaTagId(), pelicula, tag);

		TagV2 tag2 = new TagV2();
		tag2.setNombre("Psicológica");

		PeliculaTagV2 peliculaTag2 = new PeliculaTagV2(new PeliculaTagId(), pelicula, tag2);

		pelicula.getPeliculaTags().add(peliculaTag);
		pelicula.getPeliculaTags().add(peliculaTag2);

		pelicula = peliculaRepository.save(pelicula);

		System.out.println(peliculaRepository.findById(pelicula.getId()).orElse(null));

	}


}
