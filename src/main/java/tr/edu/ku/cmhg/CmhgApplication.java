package tr.edu.ku.cmhg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CmhgApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmhgApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(UserService userService) {
//        return args -> {
//            userService.saveRole(new Role(null, "ROLE_USER"));
//
//            userService.saveUser(new User(null, "kaan", "kaan", 2.0, new ArrayList<>()));
//            userService.saveUser(new User(null, "can", "can", 2.0, new ArrayList<>()));
//            userService.saveUser(new User(null, "berke", "berke", 2.0, new ArrayList<>()));
//            userService.saveUser(new User(null, "eren", "eren", 2.0, new ArrayList<>()));
//
//            userService.addRoleToUser("kaan", "ROLE_USER");
//            userService.addRoleToUser("can", "ROLE_USER");
//            userService.addRoleToUser("berke", "ROLE_USER");
//            userService.addRoleToUser("eren", "ROLE_USER");
//        };
//    }
}
