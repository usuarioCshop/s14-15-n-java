package tech.nocountry.classlodge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ClasslodgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClasslodgeApplication.class, args);
	}

}
