package com.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class MythicalMyproductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MythicalMyproductsApplication.class, args);
    }

    @Bean
    // Bean to read in the json file and and save it to the Myproducts list
    CommandLineRunner runner(MythicalMyproductsService mythicalMyproductsService) {
        return args -> {
            String jsonFile = "/json/myproducts-response.json";
            ObjectMapper jsonMapper = new ObjectMapper();
            InputStream inputStream = TypeReference.class.getResourceAsStream(jsonFile);

            try {
                Myproducts allMyproducts = jsonMapper.readValue(inputStream, Myproducts.class);
                mythicalMyproductsService.save(allMyproducts);
            }
            catch (IOException e) {
                System.out.println("Unable to get Myproducts: " + e.getMessage());
            }
        };
    }
}