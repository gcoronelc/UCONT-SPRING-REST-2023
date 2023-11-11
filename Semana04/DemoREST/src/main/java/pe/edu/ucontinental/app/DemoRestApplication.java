package pe.edu.ucontinental.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestApplication.class, args);
	}
	
	
	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/productos")
					.allowedOrigins("http://localhost:5050")
					.allowedMethods("GET","POST","PUT","PATCH");
			}
		};
	}

}
