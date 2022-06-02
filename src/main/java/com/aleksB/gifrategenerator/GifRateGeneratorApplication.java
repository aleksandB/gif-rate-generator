package com.aleksB.gifrategenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class GifRateGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GifRateGeneratorApplication.class, args);
	}

}
