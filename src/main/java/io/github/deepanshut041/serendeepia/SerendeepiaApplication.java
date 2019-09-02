package io.github.deepanshut041.serendeepia;

import io.github.deepanshut041.serendeepia.domains.Role;
import io.github.deepanshut041.serendeepia.repository.RoleRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SerendeepiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SerendeepiaApplication.class, args);
	}

	@Bean
	ApplicationRunner init(RoleRepository repository) {
		Role[] roles = {
				new Role("ROLE_USER"), new Role("ROLE_ADMIN")
		};

		return args -> {
			Stream.of(roles).forEach(
				role -> {
					if(!repository.existsByName(role.getName())) {
						repository.save(role);
					}
				}
			);

			repository.findAll().forEach(System.out::println);
		};
	}

}
