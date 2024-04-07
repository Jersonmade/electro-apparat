package com.eaprovide.electroapparat;

import com.eaprovide.electroapparat.model.User;
import com.eaprovide.electroapparat.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class ElectroApparatApplication {

    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ElectroApparatApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(UserRepo userRepo) {
        return args -> {
            User user = new User();
            user.setUsername("ADMIN");
            user.setEmail("Admin@mail.ru");
            user.setPassword(passwordEncoder.encode("123456"));

            userRepo.save(user);
        };
    }

}
