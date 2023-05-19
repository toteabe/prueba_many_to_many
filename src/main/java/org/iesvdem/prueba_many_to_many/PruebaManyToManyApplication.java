package org.iesvdem.prueba_many_to_many;

import org.iesvdem.prueba_many_to_many.domain.Rol;
import org.iesvdem.prueba_many_to_many.domain.Usuario;
import org.iesvdem.prueba_many_to_many.repository.DBRepository;
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
	CommandLineRunner runner(DBRepository dbRepository, UsuarioRepository usuarioRepository) {

		return (args) -> {

			int elminados = dbRepository.truncateAllTablesInDatabase();
			System.out.println(elminados);

			Usuario usuario = new Usuario();
			usuario.setNombre("root");

			Rol rol = new Rol();
			rol.setNombre("ADMIN");
			Rol rol2 = new Rol();
			rol2.setNombre("USER");

			usuario.getRoles().add(rol);
			usuario.getRoles().add(rol2);

			usuarioRepository.save(usuario);

		};

	}

}
