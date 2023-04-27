package com.proyecto.poyostore;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//DAO=SERVICIO
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages={"com.proyecto.poyostore.rutasController"})
public class PoyoStoreApplication{
	public static void main(String[] args) {
		SpringApplication.run(PoyoStoreApplication.class, args);
	}
}