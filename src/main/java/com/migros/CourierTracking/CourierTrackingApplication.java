package com.migros.CourierTracking;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migros.CourierTracking.Entity.MigrosStore;
import com.migros.CourierTracking.Service.MigrosStoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CourierTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourierTrackingApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(MigrosStoreService migrosStoreService){

		return args -> {
			//read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<MigrosStore>> typeReference = new TypeReference<List<MigrosStore>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/stores.json");
			try{
				List<MigrosStore> migrosStores = mapper.readValue(inputStream,typeReference);
				migrosStoreService.save(migrosStores);
				System.out.println("MigrosStores Saved!");
			}catch (IOException e){
				System.out.println("Unable to save migrosStores : " + e.getMessage());
			}
		};

	}

}
