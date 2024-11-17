package com.workbook;

import com.workbook.service.RestaurantQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WorkbookApplication {

	public static void main(String[] args) { SpringApplication.run(WorkbookApplication.class, args); }

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			RestaurantQueryService restaurantQueryService = context.getBean(RestaurantQueryService.class);

			String name = "민트초코월드";
			Long rating = 4L;

			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Score: " + rating);

			restaurantQueryService.findRestaurantsByNameAndRating(name, rating).forEach(System.out::println);
		};
	}

}
