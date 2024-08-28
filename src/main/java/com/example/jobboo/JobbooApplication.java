package com.example.jobboo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.jobboo.entity.User;
import com.example.jobboo.repository.UserRepository;

@SpringBootApplication
public class JobbooApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobbooApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UserRepository userRepository) {
		return args -> {
			User user1 = new User(null, "김민우", "잡부");
			User user2 = new User(null, "김홍집", "잡부");
			User user3 = new User(null, "나보영", "잡부");
			User user4 = new User(null, "박서연", "잡부");
			User user5 = new User(null, "박지만", "잡부");
			User user6 = new User(null, "최광진", "잡부");
			User user7 = new User(null, "홍구", "잡부");

			userRepository.saveAll(List.of(user1, user2, user3, user4, user5, user6, user7));
		};
	}
}
