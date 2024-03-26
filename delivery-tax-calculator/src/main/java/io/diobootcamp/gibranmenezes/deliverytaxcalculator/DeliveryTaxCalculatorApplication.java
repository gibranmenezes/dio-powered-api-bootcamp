package io.diobootcamp.gibranmenezes.deliverytaxcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DeliveryTaxCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryTaxCalculatorApplication.class, args);
	}

}
