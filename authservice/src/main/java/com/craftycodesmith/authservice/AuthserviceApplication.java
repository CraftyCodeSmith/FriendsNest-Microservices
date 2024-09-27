package com.craftycodesmith.authservice;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthserviceApplication implements CommandLineRunner {



	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(AuthserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.getenv().forEach((key, value) -> System.out.println(key + ": " + value));
	}

}


