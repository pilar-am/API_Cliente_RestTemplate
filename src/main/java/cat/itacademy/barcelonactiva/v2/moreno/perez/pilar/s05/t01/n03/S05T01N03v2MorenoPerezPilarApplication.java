package cat.itacademy.barcelonactiva.v2.moreno.perez.pilar.s05.t01.n03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Flors API Client", version = "1.0", description = "Api Client on consumim Flors API"))
public class S05T01N03v2MorenoPerezPilarApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N03v2MorenoPerezPilarApplication.class, args);
	}

	
	//http://localhost:9002/swagger-ui/index.html  swagger
}
