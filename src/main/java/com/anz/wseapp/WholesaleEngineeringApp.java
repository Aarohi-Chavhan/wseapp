package com.anz.wseapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
public class WholesaleEngineeringApp {

	public static void main(String[] args) {
		try {
			log.info("Initializing application...");
			SpringApplication.run(WholesaleEngineeringApp.class, args);
		}
		catch(Exception e){
			log.info("Problem Initializing application...");
			System.out.println(e.getMessage());
		}
	}

}
