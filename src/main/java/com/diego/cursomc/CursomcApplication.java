package com.diego.cursomc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diego.cursomc.services.S3Service;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//s3Service.uploadFile("C:\\Users\\diego\\Pictures\\sucesso.jpg");
		//Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaWVnb2FkcmljYW5kbzIzQGdtYWlsLmNvbSIsImV4cCI6MTU0ODExOTQyNX0.ylYEOMbGhd9RgRKFPFsQW7rVTG21YLKM3xAhIAAzQ53QJHai46PEmbGTYBTdohD8l1ATGq5oH-vHTXarGb4_Ow
	}
}