package com.proyecto.poyostore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
// Habilitamos el uso de repositorios de MongoDB en nuestra clase principal
@EnableMongoRepositories
public class PoyoStoreApplication {
	// Inyectamos el repositorio de usuarios en nuestra clase principal


	public static void main(String[] args) {
		SpringApplication.run(PoyoStoreApplication.class, args);
		System.out.println("BrandonCUM69");
	}
}