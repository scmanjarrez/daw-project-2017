package upm.etsiinf.daw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("upm.etsiinf.daw.repository")
public class DawProject2017Application {
	public static void main(String[] args) {
		SpringApplication.run(DawProject2017Application.class, args);
	}
}
