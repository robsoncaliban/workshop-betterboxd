package com.atoserobson.betterboxd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class BetterboxdApplication {

	public static void main(String[] args) {
		var app = SpringApplication.run(BetterboxdApplication.class);
		var env = app.getEnvironment();
		log.info("""


				===========================================================\n

				        Swagger UI: http://localhost:{}/docs.html \n

				===========================================================
				""", env.getProperty("server.port"));
	}

}
